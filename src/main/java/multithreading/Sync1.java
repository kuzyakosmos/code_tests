package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//пример использования synchronized
public class Sync1 {
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.main();
    }
}

class Worker {
    Random random = new Random();

    //Синхронизация на спеиально созданных для этого объектах
    //считается хорошим тоном создавать отдельные объекты (аля lock или что-то похожее)
    Object lock1 = new Object();
    Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void addToList1() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    public void addToList2() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    public void work() {
        for (int i = 0; i < 1000; i++) {
            addToList1();
            addToList2();
        }
    }

    public void main() {
        long before = System.currentTimeMillis();

        Thread thread1 = new Thread(() -> work());
        Thread thread2 = new Thread(() -> work());

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long after = System.currentTimeMillis();

        System.out.println("Time to execute program is " + (after - before));

        System.out.println("List1 size is " + list1.size());
        System.out.println("List2 size is " + list2.size());

    }
}