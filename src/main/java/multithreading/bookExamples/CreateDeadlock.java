package multithreading.bookExamples;

public class CreateDeadlock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started");
            synchronized (lock1) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                }
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        }, "Thread1");

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " started");
            synchronized (lock2) {
                synchronized (lock1) {

                }
            }
            System.out.println(Thread.currentThread().getName() + " finished");
        }, "Thread2");

        thread1.start();
        thread2.start();


    }
}
