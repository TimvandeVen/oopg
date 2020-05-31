package game;

/**
 * Location class saves the location of other objects compared to the tile map.
 *
 * @author Tim van de Ven
 */
public class Location {

    // X & Y
    public int x;
    public int y;

    /**
     * Constructor for the location class.
     *
     * @param x horizontal position of an object.
     * @param y vertical position of an object.
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Adds a direction to the current location of an object.
     *
     * @param direction direction to move the object in.
     * @return new location.
     */
    public Location add(Location direction) {
        return new Location(x + direction.x, y + direction.y);
    }
}
