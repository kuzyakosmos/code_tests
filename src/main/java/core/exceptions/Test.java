package core.exceptions;

public class Test {
    public static void main(String[] args) {
        try {
            throwException();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            throwError();
        } catch (Error er) {
            System.out.println(er.getMessage());
        }



        throw new RuntimeException("Сорян");
    }

    static void throwException() {
        throw new MyRuntimeException("Исключение");
    }

    static void throwError() {
        throw new MyError("Ошибка");
    }

    static void throwThrowable() throws MyThrowable {
        throw new MyThrowable("Throwable");
    }
}
