package core.exceptions;

public class MyThrowable extends Throwable {
    public MyThrowable() {
    }

    public MyThrowable(String message) {
        super(message);
    }

    public MyThrowable(String message, Throwable cause) {
        super(message, cause);
    }

    public MyThrowable(Throwable cause) {
        super(cause);
    }

    public MyThrowable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
