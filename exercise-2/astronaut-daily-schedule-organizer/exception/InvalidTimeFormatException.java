package exception;


public class InvalidTimeFormatException extends Exception {
    
    public InvalidTimeFormatException(String message) {
        super(message);
    }
    
    public InvalidTimeFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
