package multithreading.custom_executor_service;

import java.util.concurrent.atomic.AtomicInteger;

public class MyExecutorServiceImpl implements MyExecutorService {

    private int threads = 5;
    private AtomicInteger count = new AtomicInteger();

    public MyExecutorServiceImpl(int threads) {
        this.threads = threads;
    }

    public MyExecutorServiceImpl() {

    }

    @Override
    public void submit(Runnable task) {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public void shutdownNow() {

    }

    @Override
    public boolean awaitTermination(long millis) throws InterruptedException {
        return false;
    }

    @Override
    public int getActiveCount() {
        return 0;
    }
}
