package com.drink.drink.exception;

public class ListIsEmptyException extends RuntimeException {

    public ListIsEmptyException() {
        super();
    }

    public ListIsEmptyException(String message) {
        super(message);
    }

    public ListIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListIsEmptyException(Throwable cause) {
        super(cause);
    }

    protected ListIsEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
