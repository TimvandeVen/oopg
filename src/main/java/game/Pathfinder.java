package game;

import engine.dashboard.FPSCounter;
import engine.engine.GameEngine;
import engine.objects.Sprite;
import engine.tile.TileMap;
import engine.tile.TileType;
import engine.view.View;
import game.tiles.FloorTile;
import game.tiles.GoalTile;
import game.tiles.HoleTile;
import game.tiles.WallTile;

import java.util.HashMap;

/**
 * Pathfinder functions as the main engine,
 * it initializes and defines the game wold.
 *
 * @author Tim van de Ven
 * @version 1.0
 */
public class Pathfinder extends GameEngine {

    // Standard URL links to assets
    public final static String MEDIA_URL = "src/main/java/game/assets/";

    // Pixel size of all tiles
    public final static int TILE_SIZE = 64;

    // Screen width and screen height
    public final static int width = 1600;
    public final static int height = 896;

    // Array of custom tile types for the tilemap
    private final TileType[] tileTypes = new TileType[4];

    // List of all the levels with ID value
    public HashMap<String, Integer> levels = new HashMap<String, Integer>();

    // Current instance of the level
    protected Level level;

    /**
     * Java standard main method,
     * entry point of the program,
     * starts the game engine.
     *
     * @param args standard java parameter
     * @since 1.0
     */
    public static void main(String[] args) {
        Pathfinder main = new Pathfinder();
        main.runSketch();
    }

    /**
     * Setup for the game engine.
     *
     * @since 1.0
     */
    @Override
    public void setupGame() {
        setupFPSCounter();
        setupLevels();
        setupTiles();
        setupView();

        loadLevel(levels.get("Test"));
    }

    /**
     * Creates a FPSCounter object and sets max FPS.
     *
     * @since 1.0
     */
    private void setupFPSCounter() {
        addGameObject(new FPSCounter(10, 20), 10);
        setGameSpeed(60);
    }

    private void setupLevels() {
        levels.put("Start", 1);
        levels.put("Test", 2);
    }

    /**
     * Initializes custom tile types with their own sprite,
     * binds new tile types to a number in an array to be used by tilemap.
     *
     * @since 1.0
     */
    private void setupTiles() {
        // Initialize Sprites
        Sprite wallSprite = new Sprite(Pathfinder.MEDIA_URL.concat("wallTile.png"));
        Sprite floorSprite = new Sprite(Pathfinder.MEDIA_URL.concat("floorTile.png"));
        Sprite holeSprite = new Sprite(Pathfinder.MEDIA_URL.concat("holeTile.png"));
        Sprite goalSprite = new Sprite(Pathfinder.MEDIA_URL.concat("goalTile.png"));

        // Initialize tileTypes
        this.tileTypes[0] = new TileType<>(WallTile.class, wallSprite);
        this.tileTypes[1] = new TileType<>(FloorTile.class, floorSprite);
        this.tileTypes[2] = new TileType<>(HoleTile.class, holeSprite);
        this.tileTypes[3] = new TileType<>(GoalTile.class, goalSprite);
    }

    public void loadLevel(int id) {
        switch (id)
        {
            case 1:
            {
                int[][] tileMap = { // 0: Wall, 1: Floor, 2: Hole, 3: Goal
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };

                // Set Tile Map
                this.setTileMap(new TileMap(Pathfinder.TILE_SIZE, this.tileTypes, tileMap));

                // Start position for the player
                Location player = new Location(0, 0);

                // Initialize level
                this.level = new Level(this, id, player);
            }
            break;
            case 2:
            {
                int[][] tileMap = { // 0: Wall, 1: Floor, 2: Hole, 3: Goal
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };

                // Set Tile Map
                this.setTileMap(new TileMap(Pathfinder.TILE_SIZE, this.tileTypes, tileMap));

                // Start position for the player
                Location player = new Location(5, 5);

                // Initialize level
                this.level = new Level(this, id, player);
            }
            break;
        }
    }

    /**
     * initializes viewport and size of the sketch.
     *
     * @since 1.0
     */
    private void setupView() {
        View view = new View(width, height);

        setView(view);
        size(width, height);
    }

    /**
     * @since 1.0
     */
    @Override
    public void update() {
        if (this.level.levelComplete()) {

        }
    }

}