package game.tiles;

import engine.objects.Sprite;
import engine.tile.Tile;

/**
 * WallTile functions as basic non walkable and non stand able tile
 *
 * @author Tim van de Ven
 * @version 1.0
 */
public class WallTile extends Tile implements ITile {

    /**
     * @param sprite The image which will be drawn whenever the draw method of the tile is called.
     */
    public WallTile(Sprite sprite) {
        super(sprite);
    }

    @Override
    public boolean canWalk() {
        return false;
    }

    @Override
    public boolean canStand() {
        return false;
    }

}
