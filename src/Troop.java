/**
 * The type Troop.
 */
public abstract class Troop extends RealWarrior {
    /**
     * The Speed.
     */
    protected int speed; // 2: Slow, 3: Medium, 4: Fast
    /**
     * The Area splash.
     */
    protected boolean areaSplash;
    /**
     * The Count.
     */
    protected int count;


    /**
     * Gets speed.
     *
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Sets speed.
     *
     * @param speed the speed
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Is area splash boolean.
     *
     * @return the boolean
     */
    public boolean isAreaSplash() {
        return areaSplash;
    }

    /**
     * Gets count.
     *
     * @return the count
     */
    public int getCount() {
        return count;
    }

}
