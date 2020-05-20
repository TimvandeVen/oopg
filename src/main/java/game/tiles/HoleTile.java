package game.tiles;

import engine.objects.Sprite;
import engine.tile.Tile;

/**
 * HoleTile functions as basic walkable but non stand able tile
 *
 * @author Tim van de Ven
 * @version 1.0
 */
public class HoleTile extends Tile implements ITile {

    /**
     * @param sprite The image which will be drawn whenever the draw method of the tile is called.
     */
    public HoleTile(Sprite sprite) {
        super(sprite);
    }

    @Override
    public boolean canWalk() {
        return true;
    }

    @Override
    public boolean canStand() {
        return false;
    }

}
