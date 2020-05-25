package game;

import engine.objects.Sprite;
import engine.objects.SpriteObject;

public class Goal extends SpriteObject {

    public Goal(Location location) {
        super(new Sprite(Pathfinder.MEDIA_URL.concat("goal.png")));
        this.x = Pathfinder.TILE_SIZE * location.x;
        this.y = Pathfinder.TILE_SIZE * location.y;
    }

    @Override
    public void update() {

    }
}
