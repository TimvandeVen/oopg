package game;

import game.buttons.threadButton;

/**
 * Level class
 *
 * @author Tim van de Ven
 * @version 1.0
 */
public class Level {

    // Call methods from main
    private final Pathfinder main;

    // Player
    private final Player player;

    // Current level ID
    private final int currentLevel;

    /**
     * Constructor for Level class.
     *
     * @param main
     * @param id
     * @param playerPos
     * @since 1.0
     */
    public Level(Pathfinder main, int id, Location playerPos) {
        this.player = new Player(main, playerPos);
        this.currentLevel = id;
        this.main = main;

        setupLevel();
    }

    /**
     * Initializes the player in the level.
     *
     * @since 1.0
     */
    private void setupLevel() {
        main.addGameObject(new threadButton(main), Pathfinder.width - Pathfinder.TILE_SIZE - 10, 10, 5);
        main.addGameObject(player, player.location.x * Pathfinder.TILE_SIZE, player.location.y * Pathfinder.TILE_SIZE, 2);
    }

    /**
     * @return If current level is complete or not
     * @since 1.0
     */
    public boolean levelComplete() {
        return false;
    }

    /**
     * Returns the ID of the current level.
     *
     * @return Current level ID
     */
    public int getCurrentLevel() {
        return this.currentLevel;
    }

}
