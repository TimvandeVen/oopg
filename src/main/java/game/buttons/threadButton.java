package game.buttons;

import engine.objects.Sprite;
import game.Pathfinder;
import processing.core.PConstants;

/**
 * The thread button can pause and resume the main game thread
 *
 * @author Tim van de Ven
 * @version 1.0
 */
public class threadButton extends Button {

    public threadButton(Pathfinder main) {
        super(main, new Sprite(Pathfinder.MEDIA_URL.concat("threadButton.png")), 2);
    }

    @Override
    public void keyPressed(int keyCode, char key) {
        if (keyCode == ' ') {
            if(!main.getThreadState()) {
                nextFrame();
                main.pauseGame();
            } else {
                nextFrame();
                main.resumeGame();
            }
        }
    }

    @Override
    public void mouseClicked(int x, int y, int button) {
        if (button == PConstants.LEFT) {
            if (x > this.x && x < this.x + this.width && y > this.y && y < this.y + this.height) {
                if(!main.getThreadState()) {
                    nextFrame();
                    main.pauseGame();
                } else {
                    nextFrame();
                    main.resumeGame();
                }
            }
        }
    }
}
