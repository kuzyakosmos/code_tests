package multithreading.bookExamples;


import net.jcip.annotations.NotThreadSafe;

import java.util.concurrent.atomic.AtomicInteger;

@NotThreadSafe
public class UnsafeSequence extends Thread {
    public AtomicInteger getValue() {
        return value;
    }

    private final AtomicInteger value = new AtomicInteger();

    public int getNext() {
        return value.incrementAndGet();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            getNext();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UnsafeSequence unsafeSequence = new UnsafeSequence();

        Thread thread1 = new Thread(unsafeSequence, "thread1");
        Thread thread2 = new Thread(unsafeSequence, "thread2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(unsafeSequence.getValue());
    }
}
