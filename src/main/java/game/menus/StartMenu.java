package game.menus;

import engine.objects.Sprite;
import game.Pathfinder;
import game.buttons.LevelButton;

/**
 * Subclass for start menu.
 *
 * @author Tim van de Ven
 */
public class StartMenu extends Menu {

    // Reference to game engine class
    private final Pathfinder main;

    /**
     * Constructor for the start menu subclass.
     *
     * @param main reference to the game engine class.
     */
    public StartMenu(Pathfinder main) {
        super(main);
        this.main = main;
    }

    /**
     * Loops through the different difficulties,
     * and adds a button object to the menu.
     */
    @Override
    public void loadButtons() {
        String[] buttonText = {"easy", "medium", "hard"};
        for (int i = 0; i < buttonText.length; i++) {
            Sprite buttonSprite = new Sprite(Pathfinder.MEDIA_URL.concat(buttonText[i]).concat("Button.png"));
            main.addGameObject(new LevelButton(main, buttonSprite, 2, i), 630, 250 + (185 * i));
        }
    }
}