package by.tms.bookstorecourseworkc33.service.exception;

public class UserIsAlreadyRegisteredException extends RuntimeException {
    public UserIsAlreadyRegisteredException() {
    }

    public UserIsAlreadyRegisteredException(String message) {
        super(message);
    }

    public UserIsAlreadyRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIsAlreadyRegisteredException(Throwable cause) {
        super(cause);
    }

    public UserIsAlreadyRegisteredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
