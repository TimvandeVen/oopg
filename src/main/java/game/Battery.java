package game;

import engine.objects.AnimatedSpriteObject;
import engine.objects.Sprite;

public class Battery extends AnimatedSpriteObject {

    // Parent object
    private Light light;

    public Battery(Sprite sprite, int totalFrames, Light light) {
        super(sprite, totalFrames);
        this.light = light;
    }

    @Override
    public void update() {
        if (light.lightCharge > 66) {
            setCurrentFrameIndex(0);
        } else if (light.lightCharge > 33) {
            setCurrentFrameIndex(1);
        } else if (light.lightCharge > 0) {
            setCurrentFrameIndex(2);
        } else setCurrentFrameIndex(3);
    }
}
