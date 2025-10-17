package multithreading;

public class Sync2 {
    private int counter;

    public static void main(String[] args) throws InterruptedException {
        //при созданиии объекта создается сущность Monitor
        //Эта сущность в один момент времени может быть только у одного потока
        //он нужен чтобы джава понимала, что с объектом уже взаимодействует поток
        Sync2 sync2 = new Sync2();
        sync2.doWork();
    }

    //ключевое слово synchronized применимо к методам,
    //только один поток в момент времени может получить доступ к методу (или части кода)
    //синхронизация происходит через Monitor (читай через Объект/монитор объекта)
    private void increment() {
        synchronized (this) {
            counter++;
        }
    }

    private void doWork() throws InterruptedException {

        //Race condition
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    //Операция не атомарная (не за один такт), а за 3 такта
                    //1 считать переменную
                    //прибавить 1
                    //записать в переменную
//                    counter = counter + 1;
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();

        //подождать в потоке main потоки thread1 и thread2
        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}
