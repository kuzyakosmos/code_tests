package multithreading.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(() -> {
            throw new RuntimeException(); // увидишь в логах
        });

        executor.submit(() -> {
            throw new RuntimeException(); // тихо, пока не вызовешь get()
        });

    }
}
