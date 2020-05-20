package game.tiles;

import engine.objects.Sprite;
import engine.tile.Tile;

/**
 * GoalTile functions as walkable and stand able tile,
 * if the player collides with this tile the level is finished.
 *
 * @author Tim van de Ven
 * @version 1.0
 */
public class GoalTile extends Tile implements ITile {

    /**
     * @param sprite The image which will be drawn whenever the draw method of the tile is called.
     */
    public GoalTile(Sprite sprite) {
        super(sprite);
    }

    @Override
    public boolean canWalk() {
        return true;
    }

    @Override
    public boolean canStand() {
        return true;
    }

}