package multithreading.threadpool;

import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        //создается пул потоков
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Work(i));
        }
        executorService.shutdown();
        System.out.println("All tasks are submitted");

        executorService.awaitTermination(1, TimeUnit.DAYS);
        LinkedList list = new LinkedList();
    }
}

class Work implements Callable {
    private int id;

    public Work(int id) {
        this.id = id;
    }

//    @Override
//    public void run() {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Work " + id + " was completed");
//    }

    @Override
    public Object call() throws Exception {
//        try {
            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("Work " + id + " was completed");
        return null;
    }
}
