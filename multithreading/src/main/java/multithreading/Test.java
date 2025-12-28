package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from Thread 1");
        });

        Thread thread2 = new Thread(() -> System.out.println("Hello from Thread 2"));
        thread1.start();
        thread2.start();



        ExecutorService executorService = Executors.newFixedThreadPool(3);
    }


}
