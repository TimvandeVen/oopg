package game.menus;

import engine.objects.TextObject;
import game.Pathfinder;

/**
 * Superclass for menus. <br>
 * Draws the title.
 *
 * @author Tim van de Ven
 */
public abstract class Menu {

    /**
     * Constructor for the menu superclass.
     *
     * @param main reference to the game engine class.
     */
    public Menu(Pathfinder main) {
        // Create and add Title
        TextObject title = new TextObject("Pathfinder", 80);
        title.setForeColor(255, 255, 255, 255);
        main.addGameObject(title, 590, 40);
    }

    /**
     * Abstract method for menus, to load in buttons.
     */
    public abstract void loadButtons();

}
