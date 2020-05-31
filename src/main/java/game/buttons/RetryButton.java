package game.buttons;

import engine.objects.Sprite;
import game.Pathfinder;

/**
 * Subclass for the retry button.
 *
 * @author Tim van de Ven
 */
public class RetryButton extends Button {

    // Reference to game engine class
    private final Pathfinder main;

    /**
     * Constructor for the retry button subclass.
     *
     * @param main        reference to the game engine class.
     * @param sprite      sprite for the button.
     * @param totalFrames total frames of the button sprite for the animation.
     */
    public RetryButton(Pathfinder main, Sprite sprite, int totalFrames) {
        super(sprite, totalFrames);
        this.main = main;
    }

    /**
     * Reloads the current level.
     */
    @Override
    protected void buttonAction() {
        main.loadLevel(main.currentLevel);
    }

    /**
     * Empty
     */
    @Override
    public void update() {

    }
}
