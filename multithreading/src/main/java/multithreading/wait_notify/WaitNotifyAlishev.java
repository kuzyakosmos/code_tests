package multithreading.wait_notify;

public class WaitNotifyAlishev {
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify waitAndNotify = new WaitAndNotify();

        Thread thread1 = new Thread(() -> {
            try {
                waitAndNotify.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            waitAndNotify.consume();
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class WaitAndNotify {
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Producer thread started...");
            wait(); //метод wait может быть определен только внутри блока wait, метод будет вызываться у объекта на котором идет синхронизация
            System.out.println("Producer thread resumed...");
        }
    }

    public void consume() {

    }
}
