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

public class Player extends SpriteObject implements ICollidableWithGameObjects, ICollidableWithTiles {

    // Reference to main engine class
    private final Pathfinder main;

    // Store start location
    public Location startLocation;

    // Store player location
    public Location location;

    public Player(Pathfinder main, Location startLocation) {
        super(new Sprite(Pathfinder.MEDIA_URL.concat("player.png")));
        this.main = main;
        this.location = startLocation;
        this.startLocation = startLocation;
    }

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

    private void moveInDirection(Location direction) {
        Location newLocation = location.add(direction);
        Tile tileAtLocation = main.level.getTileAtLocation(newLocation);
        if (!(tileAtLocation instanceof WallTile)) {
            location = location.add(direction);
        }
    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject object : collidedGameObjects) {
            if (object instanceof Goal) {
                main.levelComplete = true;
                break;
            }
        }
    }

    @Override
    public void tileCollisionOccurred(List<CollidedTile> collidedTiles) {
        for (CollidedTile tile : collidedTiles) {
            if (tile.getTile() instanceof HoleTile) {
                location = startLocation;
                break;
            }
        }
    }

    @Override
    public void update() {
        this.x = Pathfinder.TILE_SIZE * location.x;
        this.y = Pathfinder.TILE_SIZE * location.y;
    }
}
