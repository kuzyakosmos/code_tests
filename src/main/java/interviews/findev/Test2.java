package interviews.findev;

public class Test2 implements Runnable {


    private int counter;
    private boolean isZero;


    public synchronized void inc() {
        System.out.println("Increment");
        counter++;
        checkCounter();
    }

    public synchronized void dec() {
        System.out.println("Decrement");
        counter--;
        checkCounter();
    }


    private void checkCounter() {
        if (counter == 0) {
            isZero = true;
        } else {
            isZero = false;
        }
    }

    synchronized public int get() {
        return counter;
    }

    public void run() {
        for (int i = 0; i < 4; i++) {
            inc();
            // try {
            //     Thread.sleep(500);
            // } catch (InterruptedException ex){
            //     System.out.println(ex.getMessage());
            // }
        }
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        Thread thread = new Thread(test2);
        thread.start();
        for (int i = 0; i < 4; i++) {
            test2.dec();

            // try {
            // Thread.sleep(500);
            // } catch (InterruptedException ex){
            // System.out.println(ex.getMessage());
            // }
        }

        try {
            thread.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(test2.get()); // 0
    }
}