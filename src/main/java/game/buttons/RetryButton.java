package game.buttons;

import engine.objects.Sprite;
import game.Pathfinder;

public class RetryButton extends Button {

    // Reference to main engine class
    private final Pathfinder main;

    public RetryButton(Pathfinder main, Sprite sprite, int totalFrames) {
        super(sprite, totalFrames);
        this.main = main;
    }

    @Override
    protected void buttonAction() {
        main.loadLevel(main.level.currentLevel);
    }

    @Override
    public void update() {

    }
}
