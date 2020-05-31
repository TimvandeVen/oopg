package game.tiles;

import engine.objects.Sprite;
import engine.tile.Tile;

/**
 * Extends tile class from game engine. <br>
 * Creates a sprite object to be set as new tile type.
 *
 * @author Tim van de Ven
 */
public class FloorTile extends Tile {

    /**
     * Constructor for the floor tile class.
     *
     * @param sprite sprite for the tile.
     */
    public FloorTile(Sprite sprite) {
        super(sprite);
    }
}
