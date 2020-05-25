package game;

import engine.objects.AnimatedSpriteObject;
import engine.objects.Sprite;

public class Light extends AnimatedSpriteObject {

    // Time of light
    private final float timeOn;

    // Light charge in percentage
    public int lightCharge = 100;

    // Store light status
    private boolean lightOn = false;

    // Start time
    private long previousMillis = System.currentTimeMillis();

    public Light(Sprite sprite, int totalFrames, float chargeTime) {
        super(sprite, totalFrames);
        this.timeOn = chargeTime;
    }

    @Override
    public void keyPressed(int keyCode, char key) {
        if (keyCode == ' ') {
            lightOn = !lightOn;
            nextFrame();
        }
    }

    @Override
    public void update() {
        if (lightOn) {
            if ((float) (System.currentTimeMillis() - previousMillis) / 1000 >= timeOn) {
                lightOn = false;
                nextFrame();
            }
        } else previousMillis = System.currentTimeMillis();
    }
}
