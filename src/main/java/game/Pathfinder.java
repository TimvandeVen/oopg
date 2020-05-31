package game;

import engine.engine.GameEngine;
import engine.objects.Sprite;
import engine.tile.TileMap;
import engine.tile.TileType;
import engine.view.View;
import game.menus.EndMenu;
import game.menus.StartMenu;
import game.tiles.FloorTile;
import game.tiles.HoleTile;
import game.tiles.WallTile;

/**
 * Functions as main engine class. <br>
 * Calls the level class and sets the game up.
 *
 * @author Tim van de Ven
 */
public class Pathfinder extends GameEngine {

    // URL to the media
    public final static String MEDIA_URL = "src/main/java/game/assets/";

    // Tile size
    public final static int TILE_SIZE = 64;

    // Main width and height
    public final int width = 1600;
    public final int height = 896;

    // Custom tile types
    public final TileType[] tileTypes = new TileType[3];

    // Current level
    public Level level;
    public int currentLevel;

    // Game status
    public boolean levelComplete;
    public boolean levelFailed;

    /**
     * Runs the processing sketch.
     *
     * @param args standard java parameter
     */
    public static void main(String[] args) {
        Pathfinder main = new Pathfinder();
        main.runSketch();
    }

    /**
     * Main setup class, used by the game engine. <br>
     * Sets the view, tiles and start menu up.
     */
    @Override
    public void setupGame() {
        setupView();
        setupTiles();

        new StartMenu(this).loadButtons();
    }

    /**
     * Setup view and background of the game.
     */
    private void setupView() {
        View view = new View(width, height);

        setView(view);
        size(width, height);

        view.setBackground(14, 14, 14);
    }

    /**
     * Initializes sprites for the tiles. <br>
     * Setup tileTypes with the sprites for the tileMap to use.
     */
    private void setupTiles() {
        // Setup tile Sprites
        Sprite wallSprite = new Sprite(Pathfinder.MEDIA_URL.concat("wallTile.png"));
        Sprite floorSprite = new Sprite(Pathfinder.MEDIA_URL.concat("floorTile.png"));
        Sprite holeSprite = new Sprite(Pathfinder.MEDIA_URL.concat("holeTile.png"));

        // Setup tileTypes
        this.tileTypes[0] = new TileType<>(WallTile.class, wallSprite);
        this.tileTypes[1] = new TileType<>(FloorTile.class, floorSprite);
        this.tileTypes[2] = new TileType<>(HoleTile.class, holeSprite);
    }

    /**
     * Deletes all previous game objects. <br>
     * Sets the tileMap. <br>
     * Loads and sets new level with all needed specifications.
     *
     * @param id level id.
     */
    public void loadLevel(int id) {
        deleteAllGameOBjects();
        switch (id) {
            case 0: {
                int[][] tileMap = { // 0: Wall, 1: Floor, 2: Hole
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 2, 2, 1, 1, 1, 2, 2, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 2, 1, 0, 2, 1, 1, 0, 0, 2, 1, 0, 2, 0, 0, 0, 1, 1, 2, 1, 0, 0},
                        {0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 2, 1, 1, 1, 2, 1, 1, 1, 0, 2, 1, 1, 2, 0, 0},
                        {0, 0, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 2, 2, 1, 0, 0, 2, 1, 0, 0, 0},
                        {0, 0, 1, 1, 0, 2, 0, 1, 2, 1, 2, 1, 1, 1, 1, 2, 0, 1, 1, 2, 1, 1, 0, 0, 0},
                        {0, 0, 0, 2, 0, 2, 1, 1, 0, 0, 0, 1, 2, 0, 1, 0, 0, 0, 1, 1, 1, 2, 0, 0, 0},
                        {0, 0, 0, 2, 1, 1, 1, 0, 1, 2, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 2, 1, 1, 1, 0, 0, 1, 2, 2, 2, 1, 0, 2, 2, 0, 1, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1, 0, 0, 2, 1, 2, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 2, 1, 1, 0, 0},
                        {0, 0, 0, 2, 1, 0, 0, 0, 2, 0, 1, 0, 0, 0, 0, 1, 0, 2, 1, 1, 1, 1, 2, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };

                // Set Tile Map
                this.setTileMap(new TileMap(Pathfinder.TILE_SIZE, this.tileTypes, tileMap));

                // Start position for the player
                Location playerLocation = new Location(15, 4);

                // Position of the goal
                Location goalLocation = new Location(8, 8);

                // Initialize level
                this.level = new Level(this, 60, 1.5f, 1f, playerLocation, goalLocation);

                // Sets the current level to the level id
                this.currentLevel = id;
            }
            break;
            case 1: {
                int[][] tileMap = { // 0: Wall, 1: Floor, 2: Hole
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 2, 1, 1, 1, 1, 0, 2, 1, 1, 1, 1, 2, 0, 2, 1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 2, 0, 1, 1, 2, 0, 1, 1, 2, 0, 1, 0, 2, 0, 1, 0, 1, 2, 0, 1, 1, 0, 0},
                        {0, 0, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 0, 1, 0, 0},
                        {0, 0, 1, 2, 1, 0, 0, 1, 1, 0, 1, 2, 0, 0, 1, 2, 2, 0, 2, 0, 1, 2, 1, 0, 0},
                        {0, 0, 1, 0, 1, 0, 2, 0, 1, 2, 1, 1, 2, 0, 1, 1, 0, 0, 1, 1, 1, 2, 1, 0, 0},
                        {0, 0, 1, 0, 1, 1, 1, 2, 1, 1, 2, 1, 1, 2, 0, 1, 1, 1, 1, 2, 2, 1, 1, 0, 0},
                        {0, 0, 1, 0, 2, 0, 2, 0, 2, 0, 0, 2, 1, 2, 0, 0, 1, 0, 2, 0, 1, 0, 1, 0, 0},
                        {0, 0, 1, 2, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 0, 0},
                        {0, 0, 1, 1, 1, 0, 1, 0, 1, 2, 0, 1, 2, 2, 1, 1, 0, 2, 1, 0, 2, 0, 1, 0, 0},
                        {0, 0, 1, 2, 0, 0, 2, 1, 0, 0, 1, 1, 1, 0, 2, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };

                // Set Tile Map
                this.setTileMap(new TileMap(Pathfinder.TILE_SIZE, this.tileTypes, tileMap));

                // Start position for the player
                Location playerLocation = new Location(4, 4);

                // Position of the goal
                Location goalLocation = new Location(20, 9);

                // Initialize level
                this.level = new Level(this, 60, 1f, 2f, playerLocation, goalLocation);

                // Sets the current level to the level id
                this.currentLevel = id;
            }
            break;
            case 2: {
                int[][] tileMap = { // 0: Wall, 1: Floor, 2: Hole
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {0, 0, 1, 0, 2, 1, 0, 0, 1, 2, 2, 0, 0, 2, 2, 0, 1, 0, 0, 2, 1, 1, 1, 0, 0},
                        {0, 0, 1, 0, 2, 1, 2, 0, 1, 1, 0, 0, 1, 2, 1, 0, 0, 1, 1, 2, 2, 2, 2, 0, 0},
                        {0, 0, 1, 0, 1, 1, 1, 0, 0, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 2, 1, 1, 0, 0, 0},
                        {0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 2, 2, 1, 2, 1, 0, 1, 1, 1, 1, 1, 2, 0, 0},
                        {0, 0, 0, 2, 0, 1, 0, 1, 0, 2, 0, 2, 0, 1, 0, 2, 0, 1, 0, 1, 0, 1, 1, 0, 0},
                        {0, 0, 1, 0, 1, 0, 2, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0},
                        {0, 0, 0, 1, 0, 2, 1, 1, 1, 2, 1, 1, 0, 2, 0, 1, 0, 1, 0, 1, 0, 2, 1, 0, 0},
                        {0, 0, 2, 1, 1, 1, 1, 0, 2, 0, 1, 0, 1, 1, 1, 1, 1, 1, 2, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 1, 0, 1, 0, 1, 0, 2, 1, 1, 1, 2, 0, 1, 0, 1, 1, 1, 1, 2, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
                };

                // Set Tile Map
                this.setTileMap(new TileMap(Pathfinder.TILE_SIZE, this.tileTypes, tileMap));

                // Start position for the player
                Location playerLocation = new Location(3, 10);

                // Position of the goal
                Location goalLocation = new Location(21, 3);

                // Initialize level
                this.level = new Level(this, 60, 0.5f, 3f, playerLocation, goalLocation);

                // Sets the current level to the level id
                this.currentLevel = id;
            }
            break;
        }
    }

    /**
     * Checks if the level is done. <br>
     * Removes all existing objects. <br>
     * Loads the end menu.
     */
    @Override
    public void update() {
        if (levelComplete || levelFailed) {
            deleteAllGameOBjects();
            this.setTileMap((new TileMap(Pathfinder.TILE_SIZE, this.tileTypes, emptyTileMap())));

            EndMenu endMenu = new EndMenu(this);
            endMenu.loadState();
            endMenu.loadButtons();

            levelComplete = false;
            levelFailed = false;
        }
    }

    /**
     * Returns an empty array to display the background.
     *
     * @return tile map with -1 on every location.
     */
    private int[][] emptyTileMap() {
        int[][] emptyTileMap = new int[25][14];
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 14; j++) {
                emptyTileMap[i][j] = -1;
            }
        }
        return emptyTileMap;
    }
}