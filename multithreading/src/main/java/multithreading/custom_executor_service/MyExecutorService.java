package multithreading.custom_executor_service;

public interface MyExecutorService {

    MyBlockingQueue queue = new MyBlockingQueue();

    public void submit(Runnable task);

    // перестаём принимать задачи, но выполняем уже поставленные
    public void shutdown();

    // пытаемся остановить немедленно
    public void shutdownNow();

    public boolean awaitTermination(long millis) throws InterruptedException;

    // сколько воркеров сейчас выполняют задачи
    public int getActiveCount();
}
