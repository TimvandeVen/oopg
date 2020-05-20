package game;

import engine.objects.Sprite;
import engine.objects.SpriteObject;

/**
 * @author Tim van de Ven
 * @version 1.0
 */
public class Player extends SpriteObject {

    // Call methods from main
    private final Pathfinder main;

    // Stores player location
    public Location location;

    // Stores players last movement
    private final Location direction = new Location(0, 0);

    /**
     * @param main
     * @param startLocation
     * @since 1.0
     */
    public Player(Pathfinder main, Location startLocation) {
        super(new Sprite(Pathfinder.MEDIA_URL.concat("player.png")));
        this.main = main;
        this.location = startLocation;
    }

    /**
     * @since 1.0
     */
    @Override
    public void update() {
        this.x = Pathfinder.TILE_SIZE * this.location.x;
        this.y = Pathfinder.TILE_SIZE * this.location.y;
    }

}
