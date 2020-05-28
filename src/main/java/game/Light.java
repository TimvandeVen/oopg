package game;

import engine.objects.AnimatedSpriteObject;
import engine.objects.Sprite;

public class Light extends AnimatedSpriteObject {

    // Time of light
    private final float charge;
    private final float recharge;

    // Light charge in percentage
    public float lightCharge = 100;

    // Store light status
    private boolean lightOn = false;

    // Start time
    private long previousMillis = System.currentTimeMillis();
    private long batteryPreviousMillis = System.currentTimeMillis();

    public Light(Sprite sprite, int totalFrames, float chargeTime, float rechargeTime) {
        super(sprite, totalFrames);
        this.charge = chargeTime;
        this.recharge = rechargeTime;
    }

    @Override
    public void keyPressed(int keyCode, char key) {
        if (keyCode == ' ') {
            if (!lightOn && lightCharge > 66) {
                lightOn = true;
                nextFrame();
            }
        }
    }

    @Override
    public void update() {
        System.out.println(lightCharge);
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
