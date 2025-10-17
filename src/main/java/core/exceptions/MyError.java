package core.exceptions;

public class MyError extends Error {
    public MyError() {
    }

    public MyError(String message) {
        super(message);
    }

    public MyError(String message, Throwable cause) {
        super(message, cause);
    }

    public MyError(Throwable cause) {
        super(cause);
    }

    public MyError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
