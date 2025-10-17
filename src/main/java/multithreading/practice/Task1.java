package multithreading.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//задал Женя
public class Task1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Foo foo = new Foo();
        executorService.submit(new Worker(foo, 1));
        executorService.submit(new Worker(foo, 2));
        executorService.submit(new Worker(foo, 3));
        executorService.shutdown();
    }
}

class Worker implements Runnable {
    public Worker(Foo foo, int i) {
        this.foo = foo;
        this.i = i;
    }

    int i;
    Foo foo;

    @Override
    public void run() {
        switch (i) {
            case (1):
                foo.first(this);
                break;
            case (2):
                foo.second(this);
                break;
            case (3):
                foo.third(this);
                break;
        }
    }
}

class Foo {
    public void first(Runnable r) {
        System.out.println("first");
    }

    public void second(Runnable r) {
        System.out.println("second");
    }

    public void third(Runnable r) {
        System.out.println("third");
    }
}