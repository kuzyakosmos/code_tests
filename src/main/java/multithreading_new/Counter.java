package multithreading_new;

public class Counter {
    private int count = 0;

    public void increment() {
        count++; // (1)
    }

    public int get() {
        return count; // (2)
    }
}
