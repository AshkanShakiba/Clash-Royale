public abstract class Troop extends RealWarrior {
    protected int speed; // 2: Slow, 3: Medium, 4: Fast
    protected boolean areaSplash;
    protected int count;


    public int getSpeed() {
        return speed;
    }

    public boolean isAreaSplash() {
        return areaSplash;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCount() {
        return count;
    }

}
