package game;

import engine.objects.Sprite;
import engine.objects.SpriteObject;

public class Goal extends SpriteObject {

    // Reference to main engine class
    private final Pathfinder main;

    // Store player location
    public Location location;

    public Goal(Pathfinder main, Location location) {
        super(new Sprite(Pathfinder.MEDIA_URL.concat("goal.png")));
        this.main = main;
        this.x = Pathfinder.TILE_SIZE * location.x;
        this.y = Pathfinder.TILE_SIZE * location.y;
    }

    @Override
    public void update() {

    }
}
