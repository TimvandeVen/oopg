package game;

import engine.objects.GameObject;
import engine.objects.TextObject;
import processing.core.PGraphics;

public class Countdown extends GameObject {

    // Reference to main engine class
    private final Pathfinder main;

    // Game Time
    private final int time;

    // Start time
    private final long previousMillis = System.currentTimeMillis();

    // Text object
    TextObject countdown;

    public Countdown(Pathfinder main, int time) {
        this.main = main;
        this.time = time;

        countdown = new TextObject(String.valueOf(time), 80);
        countdown.setForeColor(255, 255, 255, 255);
        main.addGameObject(countdown, 745, 20);
    }

    @Override
    public void update() {
        int millis = (int)(System.currentTimeMillis() - previousMillis) / 1000;
        int counter = time - millis;

        countdown.setText(String.valueOf(counter));

        if (counter <= 0) {
            main.levelFailed = true;
        }
    }

    @Override
    public void draw(PGraphics g) {

    }
}
