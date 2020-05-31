package game;

import engine.objects.GameObject;
import engine.objects.TextObject;
import processing.core.PGraphics;

/**
 * Countdown class displays the remaining time of the game.
 *
 * @author Tim van de Ven
 */
public class Countdown extends GameObject {

    // Reference to game engine class
    private final Pathfinder main;

    // Game Time
    private final int time;

    // Start time
    private final long previousMillis = System.currentTimeMillis();

    // Text object
    TextObject countdown;

    /**
     * Constructor for the countdown class.
     *
     * @param main reference to game engine class.
     * @param time total time of a level.
     */
    public Countdown(Pathfinder main, int time) {
        this.main = main;
        this.time = time;

        countdown = new TextObject(String.valueOf(time), 80);
        countdown.setForeColor(255, 255, 255, 255);
        main.addGameObject(countdown, 745, 20);
    }

    /**
     * Counts down from the start time and displays the remaining time on the screen.
     */
    @Override
    public void update() {
        int millis = (int) (System.currentTimeMillis() - previousMillis) / 1000;
        int counter = time - millis;

        countdown.setText(String.valueOf(counter));

        if (counter <= 0) {
            main.levelFailed = true;
        }
    }

    /**
     * Empty.
     *
     * @param g PGraphics object will be given by the GameEngine.
     */
    @Override
    public void draw(PGraphics g) {

    }
}
