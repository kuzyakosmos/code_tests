package multithreading.mutex;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreAlishev {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            executorService.submit(new SemaphoreTask(semaphore, i + 1));
            System.out.printf("Task %s submitted%n", i + 1);
        }

        executorService.shutdown();
    }
}

class SemaphoreTask implements Callable<String> {
    private final Semaphore semaphore;
    private final int taskId;


    public SemaphoreTask(Semaphore semaphore, int taskId) {
        this.semaphore = semaphore;
        this.taskId = taskId;
    }

    @Override
    public String call() throws Exception {
        semaphore.acquire();
        System.out.printf("Task %s is executing. Semaphore queue length: %s%n", taskId, semaphore.getQueueLength());
        Thread.sleep(1000);
        semaphore.release();
        return String.valueOf(taskId);
    }
}