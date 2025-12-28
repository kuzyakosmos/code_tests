package multithreading.counters;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class Counter1 {

    private final AtomicInteger atomicInteger = new AtomicInteger();

    private final LongAdder longAdder = new LongAdder();

    private int counter;

    // Execution time: 1 min 1 sec 130 ms
    void incrementAtomicInt() {
        atomicInteger.incrementAndGet();
    }

    // Execution time: 0 min 8 sec 29 ms
    void incrementLongAdder() {
        longAdder.increment();
    }

    // Execution time: 0 min 12 sec 43 ms
    synchronized void syncIncrement() {
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Counter1 counter1 = new Counter1();
        for (int i = 0; i < 10_000_000; i++) {
            executorService.submit(() -> {
                for (int j = 0; j < 100; j++) {
//                    counter1.syncIncrement();
                    counter1.incrementAtomicInt();
//                    counter1.incrementLongAdder();
                }
            });
        }

        //почему когда я ставлю timeout больше то и программа дольше выполняется?
        //а еще я перепутал местами две строчки ниже и это было ооочень медленно
        executorService.shutdown();
        boolean executed = executorService.awaitTermination(5, TimeUnit.MINUTES);

        long end = System.nanoTime();
        Duration d = Duration.ofNanos(end - start);

        System.out.printf(
                "Executed: %s Counter: %d, Execution time: %d min %d sec %d ms%n",
                executed,
//                counter1.counter,
                counter1.atomicInteger.intValue(),
//                counter1.longAdder.sum(),
                d.toMinutes(),
                d.toSecondsPart(),
                d.toMillisPart()
        );
    }
}
