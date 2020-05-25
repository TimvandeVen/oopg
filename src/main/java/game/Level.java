package game;

import engine.dashboard.FPSCounter;
import engine.objects.Sprite;
import engine.tile.Tile;

public class Level {

    // Reference to main engine class
    private final Pathfinder main;

    // Player object
    private final Player player;

    // Goal object
    private final Goal goal;

    // Current ID
    private final int currentLevel;

    // Light Charge
    private final int lightCharge;

    public Level(Pathfinder main, int time, int lightCharge, int id, Location playerLocation, Location goalLocation) {
        this.main = main;
        this.currentLevel = id;
        this.player = new Player(main, playerLocation);
        this.goal = new Goal(main, goalLocation);
        this.lightCharge = lightCharge;

        setupLevel();
        setupCountdown();
    }

    private void setupLevel() {
        // FPS Counter
        main.addGameObject(new FPSCounter(10, 20), 5);
        // Light
        main.addGameObject(new Light(lightCharge, new Sprite(Pathfinder.MEDIA_URL.concat("light.png")), 2));
        // Player
        main.addGameObject(player, 1);
        // Goal
        main.addGameObject(goal, 0);
    }

    private void setupCountdown() {

    }

    public Tile getTileAtLocation(Location tileLocation) {
        return main.getTileMap().getTileOnIndex(tileLocation.x, tileLocation.y);
    }
}
