package by.tms.bookstorecourseworkc33.service.exception;

public class SuchUserIsAlreadyRegisteredException extends RuntimeException{
    public SuchUserIsAlreadyRegisteredException() {
    }

    public SuchUserIsAlreadyRegisteredException(String message) {
        super(message);
    }

    public SuchUserIsAlreadyRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public SuchUserIsAlreadyRegisteredException(Throwable cause) {
        super(cause);
    }

    public SuchUserIsAlreadyRegisteredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
