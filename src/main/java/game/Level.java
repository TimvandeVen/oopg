package game;

import engine.objects.Sprite;
import engine.tile.Tile;

public class Level {

    // Reference to main engine class
    private final Pathfinder main;

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

    public Tile getTileAtLocation(Location tileLocation) {
        return main.getTileMap().getTileOnIndex(tileLocation.x, tileLocation.y);
    }
}
