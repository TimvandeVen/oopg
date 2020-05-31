package game;

import engine.collision.CollidedTile;
import engine.collision.ICollidableWithGameObjects;
import engine.collision.ICollidableWithTiles;
import engine.objects.GameObject;
import engine.objects.Sprite;
import engine.objects.SpriteObject;
import engine.tile.Tile;
import game.tiles.HoleTile;
import game.tiles.WallTile;
import processing.core.PConstants;

import java.util.List;

/**
 * Sprite object of the player object. <br>
 * Implements colliding classes.
 *
 * @author Tim van de Ven
 */
public class Player extends SpriteObject implements ICollidableWithGameObjects, ICollidableWithTiles {

    // Store start location
    public final Location startLocation;
    // Reference to game engine class
    private final Pathfinder main;
    // Store player location
    public Location location;

    /**
     * Constructor for the player class.
     *
     * @param main          reference to the game engine class.
     * @param startLocation starting location of the player.
     */
    public Player(Pathfinder main, Location startLocation) {
        super(new Sprite(Pathfinder.MEDIA_URL.concat("player.png")));
        this.main = main;
        this.location = startLocation;
        this.startLocation = startLocation;
    }

    /**
     * Checks if the movement keys are pressed.
     *
     * @param keyCode code of the key that is pressed.
     * @param key     char of the key that is pressed
     */
    @Override
    public void keyPressed(int keyCode, char key) {
        Location direction = new Location(0, 0);
        if (key == 'a' || keyCode == PConstants.LEFT) {
            direction.x = -1;
        } else if (key == 'd' || keyCode == PConstants.RIGHT) {
            direction.x = 1;
        } else if (key == 'w' || keyCode == PConstants.UP) {
            direction.y = -1;
        } else if (key == 's' || keyCode == PConstants.DOWN) {
            direction.y = 1;
        }
        moveInDirection(direction);
    }

    /**
     * Moves the location of the player in te specified direction.
     *
     * @param direction direction that the player is moving in.
     */
    private void moveInDirection(Location direction) {
        Location newLocation = location.add(direction);
        Tile tileAtLocation = main.level.getTileAtLocation(newLocation);
        if (!(tileAtLocation instanceof WallTile)) {
            location = location.add(direction);
        }
    }

    /**
     * Checks if the player collides with the goal object. <br>
     * The game is won when true.
     *
     * @param collidedGameObjects The GameObjects with which a collision should be detected
     */
    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject object : collidedGameObjects) {
            if (object instanceof Goal) {
                main.levelComplete = true;
                break;
            }
        }
    }

    /**
     * Checks if the player is walking on a hole tile. <br>
     * Resets the player when true.
     *
     * @param collidedTiles The tiles with which a collision should be detected
     */
    @Override
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
        for (CollidedTile tile : collidedTiles) {
            if (tile.getTile() instanceof HoleTile) {
                location = startLocation;
                break;
            }
        }
    }

    /**
     * Updates the actual location x and y of the player over the tile map.
     */
    @Override
    public void update() {
        this.x = Pathfinder.TILE_SIZE * location.x;
        this.y = Pathfinder.TILE_SIZE * location.y;
    }
}
