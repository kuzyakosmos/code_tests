package multithreading.anonymus_thread;

public class Main {
    public static void main(String[] args) {
//        Main main = new Main();
//        main.test();
//
//        int x = 10;
//        new Thread(() -> System.out.println(x)).start();
//
//        final int[] counter = {0};
//
//        for (int i = 0; i < 10; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    synchronized (counter) {
//                        counter[0]++;
//                    }
//                }
//            }).start();
//        }

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            new Thread(() -> System.out.println(finalI)).start();
        }
    }

    void count(int counter) {
        counter++;
    }

    void test() {
        //лямбда в this выведет сам класс Main@36ee7cc2, так как своего this у нее нет
        //и лямбда не будет работать из статического метода - в static методе нет this, Lambda берёт this извне, брать неоткуда
        new Thread(() -> {
            System.out.println(this);
        }).start();

        //Анонимный класс тк создает новый объект, у него свой this - выведет этот объект Main$1@ab6892c
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(this);
            }
        }).start();
    }
}
