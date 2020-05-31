package game.tiles;

import engine.objects.Sprite;
import engine.tile.Tile;

/**
 * Extends tile class from game engine. <br>
 * Creates a sprite object to be set as new tile type.
 *
 * @author Tim van de Ven
 */
public class WallTile extends Tile {

    /**
     * Constructor for the wall tile class.
     *
     * @param sprite sprite for the tile.
     */
    public WallTile(Sprite sprite) {
        super(sprite);
    }
}
