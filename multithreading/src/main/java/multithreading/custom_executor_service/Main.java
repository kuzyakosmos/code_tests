package multithreading.custom_executor_service;

import java.util.concurrent.*;

public class Main {
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);
    private static volatile int n;

    public static void main(String[] args) {
        Worker worker = new Worker();

        executorService.submit(worker);
        executorService.submit(worker);
        executorService.submit(worker);

        executorService.submit(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " anonymus n=" + n);
                n++;
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    static class Worker implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " n=" + n);
                n++;
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
