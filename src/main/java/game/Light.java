package game;

import engine.objects.AnimatedSpriteObject;
import engine.objects.Sprite;

/**
 * Light class is an animated sprite object that darkens or lightens the game screen.
 *
 * @author Tim van de Ven
 */
public class Light extends AnimatedSpriteObject {

    // Time the light is on/off
    private final float charge;
    private final float recharge;

    // Light charge in percentage
    public float lightCharge = 100;

    // Store light status
    private boolean lightOn = false;

    // Start time
    private long previousMillis = System.currentTimeMillis();
    private long batteryPreviousMillis = System.currentTimeMillis();

    /**
     * Constructor for the light class.
     *
     * @param sprite       sprite for the light.
     * @param totalFrames  total frames of the light sprite for the animation.
     * @param chargeTime   total time that the light can be on.
     * @param rechargeTime total time that the light  needs to recharge.
     */
    public Light(Sprite sprite, int totalFrames, float chargeTime, float rechargeTime) {
        super(sprite, totalFrames);
        this.charge = chargeTime;
        this.recharge = rechargeTime;
    }

    /**
     * Checks if the space key is pressed.
     *
     * @param keyCode code of the key that is pressed.
     * @param key     char of the key that is pressed.
     */
    @Override
    public void keyPressed(int keyCode, char key) {
        if (keyCode == ' ') {
            if (!lightOn && lightCharge > 66) {
                lightOn = true;
                nextFrame();
            }
        }
    }

    /**
     * Checks if the light is on. <br>
     * When the light is on, a countdown will start. <br>
     * A second countdown will start that is split into four, used by the battery. <br>
     * When the light is of a countdown will start to charge the light.
     */
    @Override
    public void update() {
        if (lightOn) {
            if ((float) (System.currentTimeMillis() - previousMillis) / 1000 >= charge) {
                lightOn = false;
                nextFrame();
            }
            if ((float) (System.currentTimeMillis() - batteryPreviousMillis) / 1000 >= (charge / 4)) {
                batteryPreviousMillis = System.currentTimeMillis();
                lightCharge -= (100f / 3);
            }
        } else {
            if (lightCharge < 100) {
                if ((float) (System.currentTimeMillis() - batteryPreviousMillis) / 1000 >= (recharge / 4)) {
                    batteryPreviousMillis = System.currentTimeMillis();
                    lightCharge += (100f / 3);
                }
            }
            previousMillis = System.currentTimeMillis();
        }
    }
}
