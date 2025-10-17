package multithreading.volotile;

public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker();

    }
}

class Worker {
   volatile int i = 0;

    Thread thread1 = new Thread(this::run1);
    Thread thread2 = new Thread(this::run2);
    Thread thread3 = new Thread(this::count);


    {
        thread1.start();
        thread2.start();
        thread3.start();
    }

    void run1() {
        while (true) {
            System.out.println("Thread 1: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void run2() {
        while (true) {
            System.out.println("Thread 2: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void count() {
        while (true) {
            i++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}