package game;

import engine.objects.AnimatedSpriteObject;
import engine.objects.Sprite;

import java.util.concurrent.TimeUnit;

public class Light extends AnimatedSpriteObject {

    // Light state
    public boolean lightOn;

    public boolean canTurnLightOn;

    private int maxLightCharge;

    private int lightCharge;

    private long startTime = System.nanoTime();

    public Light(int lightCharge, Sprite sprite, int totalFrames) {
        super(sprite, totalFrames);
//        Battery battery = new Battery();
        this.maxLightCharge = lightCharge;
        this.lightCharge = maxLightCharge;
        canTurnLightOn = true;
        lightOn = false;
    }

    @Override
    public void keyPressed(int keyCode, char key) {
        if (keyCode == ' ' && canTurnLightOn) {
            lightOn = !lightOn;
            nextFrame();
        }
    }

    @Override
    public void update() {
//        final long time = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - startTime);
//        System.out.println(lightCharge);
//        if (lightOn) {
//            if (lightCharge <= 0) {
//                lightOn = false;
//                nextFrame();
//            } else {
//                lightCharge -= time;
//            }
//        } else if (lightCharge < maxLightCharge) {
//            canTurnLightOn = false;
//        } else {
//            canTurnLightOn = true;
//        }
    }
}
