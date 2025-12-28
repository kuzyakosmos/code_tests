package multithreading.producer_consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerAlishev {
    private static final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                ProducerConsumerAlishev.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                ProducerConsumerAlishev.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();

//        thread1.join();
//        thread2.join();

    }

    private static void produce() throws InterruptedException {
        Random random = new Random();

        while (true) {
//            Thread.sleep(90);
            queue.put(random.nextInt(100));
        }
    }

    private static void consume() throws InterruptedException {
        while (true) {
            Thread.sleep(100);
            var value = queue.take();
            System.out.println(value);
            System.out.println("Queue size is " + queue.size());
        }
    }


}
