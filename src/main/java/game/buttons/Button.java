package game.buttons;

import engine.objects.AnimatedSpriteObject;
import engine.objects.Sprite;

public abstract class Button extends AnimatedSpriteObject {

    public Button(Sprite sprite, int totalFrames) {
        super(sprite, totalFrames);
    }

    @Override
    public abstract void mousePressed(int x, int y, int button);

    @Override
    public abstract void mouseMoved(int x, int y);
}
