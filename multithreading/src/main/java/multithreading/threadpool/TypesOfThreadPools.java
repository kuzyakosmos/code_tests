package multithreading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TypesOfThreadPools {
    public static void main(String[] args) {
        ExecutorService executorService;
        executorService = Executors.newFixedThreadPool(2);
        executorService = Executors.newCachedThreadPool();
        executorService = Executors.newScheduledThreadPool(2);
        executorService = Executors.newSingleThreadExecutor();
    }
}
