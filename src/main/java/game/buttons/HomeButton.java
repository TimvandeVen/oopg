package game.buttons;

import engine.objects.Sprite;
import game.Pathfinder;
import game.menus.StartMenu;

/**
 * Subclass for the home button.
 *
 * @author Tim van de Ven
 */
public class HomeButton extends Button {

    // Reference to game engine class
    private final Pathfinder main;

    /**
     * Constructor for the home button subclass.
     *
     * @param main        reference to the game engine class.
     * @param sprite      sprite for the button.
     * @param totalFrames total frames of the button sprite for the animation.
     */
    public HomeButton(Pathfinder main, Sprite sprite, int totalFrames) {
        super(sprite, totalFrames);
        this.main = main;
    }

    /**
     * Removes all previous game objects. <br>
     * Initializes the start menu.
     */
    @Override
    protected void buttonAction() {
        main.deleteAllGameOBjects();
        new StartMenu(main).loadButtons();
    }

    /**
     * Empty.
     */
    @Override
    public void update() {

    }
}
