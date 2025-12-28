package interviews.findev;

public class Exceptions {

    public static void main(String[] args) {
        try {
            int i = 1/0;
            System.out.println("1");
        } catch (ArithmeticException e) {
            System.out.println("2");
            throw new RuntimeException(); //это исключение не будет поймано catch!!!
        } catch (Exception e) {
            System.out.println("3");
        } finally {
            System.out.println("4");
        }
        System.out.println("5");
    }
}