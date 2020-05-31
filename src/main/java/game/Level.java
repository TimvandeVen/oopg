package game;

import engine.objects.Sprite;
import engine.tile.Tile;

/**
 * Level class adds all the necessary game object to the game.
 *
 * @author Tim van de Ven
 */
public class Level {

    // Reference to game engine class
    private final Pathfinder main;

    /**
     * Constructor for the level class.
     *
     * @param main           reference to the game engine class.
     * @param gameTime       total time of the game.
     * @param batteryTime    total time that the light can be on.
     * @param rechargeTime   total time that the light needs to recharge.
     * @param playerLocation starting position of the player.
     * @param goalLocation   starting position of the goal object.
     */
    public Level(Pathfinder main, int gameTime, float batteryTime, float rechargeTime, Location playerLocation, Location goalLocation) {
        this.main = main;

        // Light
        Light light = new Light(new Sprite(Pathfinder.MEDIA_URL.concat("light.png")), 2, batteryTime, rechargeTime);
        main.addGameObject(light);

        // Battery
        main.addGameObject(new Battery(new Sprite(Pathfinder.MEDIA_URL.concat("battery.png")), 4, light), 680, 780);

        // Countdown
        main.addGameObject(new Countdown(main, gameTime));

        // Player
        main.addGameObject(new Player(main, playerLocation), 1);

        // Goal
        main.addGameObject(new Goal(goalLocation), 0);
    }

    /**
     * Returns the tile type of a tile on a specified location.
     *
     * @param tileLocation location of the tile.
     * @return tile type of tile on location.
     */
    public Tile getTileAtLocation(Location tileLocation) {
        return main.getTileMap().getTileOnIndex(tileLocation.x, tileLocation.y);
    }
}
