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

    @Override
    public void mousePressed(int x, int y, int button) {
        if (button == PConstants.LEFT) {
            if (x > this.x && x < this.x + this.width && y > this.y && y < this.y + this.height) {
                main.loadLevel(id);
            }
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        if (x > this.x && x < this.x + this.width && y > this.y && y < this.y + this.height) {
            setCurrentFrameIndex(1);
        } else setCurrentFrameIndex(0);
    }

    @Override
    public void update() {

    }
}
