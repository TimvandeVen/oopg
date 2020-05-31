package game.buttons;

import engine.objects.Sprite;
import game.Pathfinder;

/**
 * Subclass for the level button.
 *
 * @author Tim van de Ven
 */
public class LevelButton extends Button {

    // Reference to game engine class
    private final Pathfinder main;

    // Level id
    private final int id;

    /**
     * Constructor for the level button subclass.
     *
     * @param main        reference to the game engine class.
     * @param sprite      sprite for the button.
     * @param totalFrames total frames of the button sprite for the animation.
     * @param id          level id.
     */
    public LevelButton(Pathfinder main, Sprite sprite, int totalFrames, int id) {
        super(sprite, totalFrames);
        this.main = main;
        this.id = id;
    }

    /**
     * Loads the level corresponding with the pressed button.
     */
    protected void buttonAction() {
        main.loadLevel(id);
    }

    /**
     * Empty.
     */
    @Override
    public void update() {

    }
}
