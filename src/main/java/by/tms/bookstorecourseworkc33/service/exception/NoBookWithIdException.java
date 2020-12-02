package by.tms.bookstorecourseworkc33.service.exception;

public class NoBookWithIdException extends RuntimeException {
    public NoBookWithIdException() {
    }

    public NoBookWithIdException(String message) {
        super(message);
    }

    public NoBookWithIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoBookWithIdException(Throwable cause) {
        super(cause);
    }

    public NoBookWithIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
