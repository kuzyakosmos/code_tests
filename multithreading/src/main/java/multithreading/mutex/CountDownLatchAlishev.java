package multithreading.mutex;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//перевод - счетчик назад пока не отопрется защелка
public class CountDownLatchAlishev {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 3; i++) {
                executorService.execute(new Processor(i, countDownLatch));
            }
            executorService.shutdown();
            for (int i = 0; i < 3; i++) {
                Thread.sleep(1000);
                countDownLatch.countDown();
            }
            System.out.println("Latch has been opened");
        }
    }
}

class Processor implements Runnable {
    private int id;
    private final CountDownLatch countDownLatch;

    public Processor(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            countDownLatch.await();
            System.out.println("Thread " + id + " continue working");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}