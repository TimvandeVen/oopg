package game.buttons;

import engine.objects.AnimatedSpriteObject;
import engine.objects.Sprite;
import game.Pathfinder;

/**
 * Super class for a button that can be activated by a key- and mouse event
 *
 * @author Tim van de Ven
 * @version 1.0
 */
public class Button extends AnimatedSpriteObject {

    // Call methods from main
    protected Pathfinder main;

    /**
     * Constructor for Button class
     *
     * @param main   Allows button to call methods from main
     * @param sprite The image of the button
     * @since 1.0
     */
    public Button(Pathfinder main, Sprite sprite, int frames) {
        super(sprite, frames);
        this.main = main;
    }

    /**
     * Not used
     */
    @Override
    public void update() {

    }
}
