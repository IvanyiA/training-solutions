package exceptionmulticatch.converter;

public class InvalidBinaryStringException extends RuntimeException{

    public InvalidBinaryStringException() {
        super();
    }

    public InvalidBinaryStringException(String message) {
        super(message);
    }

    public InvalidBinaryStringException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidBinaryStringException(Throwable cause) {
        super(cause);
    }

    public InvalidBinaryStringException(String message, Throwable cause, boolean enableSupression, boolean writableStackTrace) {
        super(message, cause, enableSupression, writableStackTrace);
    }

}
