package game;

public class Location {

    public int x;
    public int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Location add(Location direction) {
        return new Location(x + direction.x, y + direction.y);
    }
}
