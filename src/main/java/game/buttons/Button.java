package game.buttons;

import engine.objects.AnimatedSpriteObject;
import engine.objects.Sprite;
import processing.core.PConstants;

/**
 * Superclass for buttons. <br>
 * Checks if the mouse is hovering over a button. <br>
 * Also checks if the button is pressed.
 *
 * @author Tim van de Ven
 */
public abstract class Button extends AnimatedSpriteObject {

    /**
     * Constructor for the button superclass.
     *
     * @param sprite      sprite for the button.
     * @param totalFrames total frames of the button sprite for the animation.
     */
    public Button(Sprite sprite, int totalFrames) {
        super(sprite, totalFrames);
    }

    /**
     * @param x      horizontal position of the mouse.
     * @param y      vertical postition of the mouse.
     * @param button button on the mouse that is pressed.
     */
    @Override
    public void mousePressed(int x, int y, int button) {
        if (button == PConstants.LEFT) {
            if (x > this.x && x < this.x + this.width && y > this.y && y < this.y + this.height) {
                buttonAction();
            }
        }
    }

    /**
     * Switches between the frames of the button sprite on hover.
     *
     * @param x horizontal position of the mouse.
     * @param y vertical postition of the mouse.
     */
    @Override
    public void mouseMoved(int x, int y) {
        if (x > this.x && x < this.x + this.width && y > this.y && y < this.y + this.height) {
            setCurrentFrameIndex(1);
        } else setCurrentFrameIndex(0);
    }

    /**
     * Abstract method for buttons, runs when button is pressed.
     */
    protected abstract void buttonAction();
}
