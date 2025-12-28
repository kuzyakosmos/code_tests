package core.exceptions;

public class Main {
    public static void main(String[] args) {
        try {
            methodWithError();
        } catch (MyCustomException ex) {
            System.out.println("MyCustomException: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        } finally {
            System.out.println("Finally block was executed");
        }

    }

    static void methodWithError() throws MyCustomException {
        throw new MyCustomException("Custom exception occurred");
    }
}

class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}
