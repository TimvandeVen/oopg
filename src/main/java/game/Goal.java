package game;

import engine.objects.Sprite;
import engine.objects.SpriteObject;

/**
 * Sprite object that positions the goal object.
 *
 * @author Tim van de Ven
 */
public class Goal extends SpriteObject {

    /**
     * Constructor for the goal class.
     *
     * @param location location of the goal object.
     */
    public Goal(Location location) {
        super(new Sprite(Pathfinder.MEDIA_URL.concat("goal.png")));
        this.x = Pathfinder.TILE_SIZE * location.x;
        this.y = Pathfinder.TILE_SIZE * location.y;
    }

    /**
     * Empty.
     */
    @Override
    public void update() {

    }
}
