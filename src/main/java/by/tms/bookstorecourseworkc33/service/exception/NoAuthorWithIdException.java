package by.tms.bookstorecourseworkc33.service.exception;

public class NoAuthorWithIdException extends RuntimeException{
    public NoAuthorWithIdException() {
    }

    public NoAuthorWithIdException(String message) {
        super(message);
    }

    public NoAuthorWithIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAuthorWithIdException(Throwable cause) {
        super(cause);
    }

    public NoAuthorWithIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
