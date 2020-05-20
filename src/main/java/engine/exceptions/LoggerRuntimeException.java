package engine.exceptions;

/**
 * Used by the logger object.
 */
public class LoggerRuntimeException extends RuntimeException {
	
    public LoggerRuntimeException(Throwable cause) {
        super(cause);
    }
}
