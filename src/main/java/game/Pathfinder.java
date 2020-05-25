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
 * Functions as main engine class.
 * @author Tim van de Ven
 * @version 1.0
 * @since 25-05-2020
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

    // Game status
    public boolean levelComplete;
    public boolean levelFailed;

    public static void main(String[] args) {
        Pathfinder main = new Pathfinder();
        main.runSketch();
    }

    @Override
    public void setupGame() {
        setupView();
        setupTiles();

        new StartMenu(this);
    }

    private void setupView() {
        View view = new View(width, height);

        setView(view);
        size(width, height);

        view.setBackground(14, 14, 14);
    }

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

    public void loadLevel(int id) {
        deleteAllGameOBjects();
        switch (id) {
            case 0: {
                int[][] tileMap = { // 0: Wall, 1: Floor, 2: Hole
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
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

                // Level time in seconds
                int time = 60;

                // Light charge in seconds
                int lightCharge = 3;

                // Start position for the player
                Location playerLocation = new Location(2, 2);

                // Position of the goal
                Location goalLocation = new Location(2, 5);

                // Initialize level
                this.level = new Level(this, time, lightCharge, id, playerLocation, goalLocation);
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

                // Level time in seconds
                int time = 10;

                // Light charge in seconds
                int lightCharge = 300;

                // Start position for the player
                Location playerLocation = new Location(4, 4);

                // Position of the goal
                Location goalLocation = new Location(20, 9);

                // Initialize level
                this.level = new Level(this, time, lightCharge, id, playerLocation, goalLocation);
            }
            break;
            case 2: {
                int[][] tileMap = { // 0: Wall, 1: Floor, 2: Hole
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
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

                // Level time in seconds
                int time = 60;

                // Light charge in seconds
                int lightCharge = 3;

                // Start position for the player
                Location playerLocation = new Location(10, 10);

                // Position of the goal
                Location goalLocation = new Location(10, 12);

                // Initialize level
                this.level = new Level(this, time, lightCharge, id, playerLocation, goalLocation);
            }
            break;
        }
    }

    @Override
    public void update() {
        if (levelComplete || levelFailed) {
            deleteAllGameOBjects();
            this.setTileMap((new TileMap(Pathfinder.TILE_SIZE, this.tileTypes, emptyTileMap())));
            new EndMenu(this);
            levelComplete = false;
            levelFailed = false;
        }
    }

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