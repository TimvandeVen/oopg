package game.menus;

import engine.objects.Sprite;
import engine.objects.TextObject;
import game.Pathfinder;
import game.buttons.HomeButton;
import game.buttons.RetryButton;

/**
 * Subclass for end menu.
 *
 * @author Tim van de Ven
 */
public class EndMenu extends Menu {

    // Reference to game engine class
    private final Pathfinder main;

    /**
     * Constructor for the end menu subclass.
     *
     * @param main reference to the game engine class.
     */
    public EndMenu(Pathfinder main) {
        super(main);
        this.main = main;
    }

    /**
     * Loads in text object that shows if the game was won or lost.
     */
    public void loadState() {
        if (main.levelComplete) {
            TextObject win = new TextObject("Goal Achieved!", 50);
            win.setForeColor(106, 205, 23, 255);
            main.addGameObject(win, 600, 275);
        } else if (main.levelFailed) {
            TextObject loss = new TextObject("You lost!", 50);
            loss.setForeColor(124, 39, 32, 255);
            main.addGameObject(loss, 670, 275);
        }
    }

    /**
     * Adds home and retry buttons to the menu.
     */
    @Override
    public void loadButtons() {
        main.addGameObject(new HomeButton(main, new Sprite(Pathfinder.MEDIA_URL.concat("homeButton.png")), 2), 830, 500);
        main.addGameObject(new RetryButton(main, new Sprite(Pathfinder.MEDIA_URL.concat("retryButton.png")), 2), 390, 500);
    }
}
