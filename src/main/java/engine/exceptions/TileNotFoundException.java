package engine.exceptions;

/**
 * Used by the TileType object.
 */
public class TileNotFoundException extends RuntimeException {

    public TileNotFoundException(String message) {
        super(message);
    }
}
