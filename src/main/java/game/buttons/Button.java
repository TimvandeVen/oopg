package game.buttons;

import engine.objects.AnimatedSpriteObject;
import engine.objects.Sprite;
import processing.core.PConstants;

/**
 * Superclass for buttons.
 * @author Tim van de Ven
 * @version 1.1
 * @since 25-05-2020
 */
public abstract class Button extends AnimatedSpriteObject {

    public Button(Sprite sprite, int totalFrames) {
        super(sprite, totalFrames);
    }

    @Override
    public void mousePressed(int x, int y, int button) {
        if (button == PConstants.LEFT) {
            if (x > this.x && x < this.x + this.width && y > this.y && y < this.y + this.height) {
                buttonAction();
            }
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        if (x > this.x && x < this.x + this.width && y > this.y && y < this.y + this.height) {
            setCurrentFrameIndex(1);
        } else setCurrentFrameIndex(0);
    }

    protected abstract void buttonAction();
}
