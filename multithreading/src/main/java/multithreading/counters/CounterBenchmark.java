package multithreading.counters;

import org.openjdk.jmh.annotations.*;

@State(Scope.Benchmark)
public class CounterBenchmark {

    private Counter counter;

    @Setup(Level.Iteration)
    public void setup() {
        counter = new Counter();
    }

    @Benchmark
    @Threads(10)
    public void synchronizedIncrement() {
        counter.increment();
    }

    static class Counter {
        private int value = 0;

        synchronized void increment() {
            value++;
        }
    }
}
