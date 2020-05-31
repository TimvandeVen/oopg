package game;

import engine.objects.AnimatedSpriteObject;
import engine.objects.Sprite;

/**
 * Animated sprite object that shows the light charge.
 *
 * @author Tim van de Ven
 */
public class Battery extends AnimatedSpriteObject {

    // Reference to light object
    private final Light light;

    /**
     * Constructor for the battery class.
     *
     * @param sprite      sprite for the battery.
     * @param totalFrames total frames for the animation.
     * @param light       reference to the light object of the level.
     */
    public Battery(Sprite sprite, int totalFrames, Light light) {
        super(sprite, totalFrames);
        this.light = light;
    }

    /**
     * Changes the battery sprite depending on the current light charge.
     */
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
