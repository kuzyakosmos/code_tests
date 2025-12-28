package interviews.findev;

public class TestThread {
    public static void main(String[] args) {
        Object a = new Object();
        Thread t = new Thread(() -> {
            try {
//                int i = 1;
//                while (true) {
//                    i++;
//                }
                while (true) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {

            }
        });
        t.start();
        t.interrupt();
        System.out.println("Поток main завершил свою работу");

        if (t.isInterrupted()) {
            System.out.println("Анонимный поток корректно завершился");
        }
    }
}