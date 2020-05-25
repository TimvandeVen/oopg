package game.buttons;

import engine.objects.Sprite;
import game.Pathfinder;
import processing.core.PConstants;

public class LevelButton extends Button {

    // Reference to main engine class
    private final Pathfinder main;

    // Level ID
    private final int id;

    public LevelButton(Pathfinder main, Sprite sprite, int totalFrames, int id) {
        super(sprite, totalFrames);
        this.main = main;
        this.id = id;
    }

    protected void buttonAction() {
        main.loadLevel(id);
    }

    @Override
    public void update() {

    }
}
