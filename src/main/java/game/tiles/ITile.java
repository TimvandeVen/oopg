package game.tiles;

/**
 * ITile functions as interface for all tiles,
 * defines whether a tile can be walked on and if a tile can be stood on
 *
 * @author Tim van de Ven
 * @version 1.0
 */
public interface ITile {

    /**
     * @return if tile can be walked on by player
     */
    boolean canWalk();

    /**
     * @return if tile can be stood on by player.
     */
    boolean canStand();

}
