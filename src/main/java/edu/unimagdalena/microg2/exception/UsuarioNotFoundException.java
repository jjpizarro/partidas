package edu.unimagdalena.microg2.exception;

public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException() {
    }

    public UsuarioNotFoundException(String message) {
        super(message);
    }

    public UsuarioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsuarioNotFoundException(Throwable cause) {
        super(cause);
    }

    public UsuarioNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
