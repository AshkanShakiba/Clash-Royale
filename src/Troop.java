public abstract class Troop extends RealWarriors {
    protected int speed; // 2: Slow, 3: Medium, 4: Fast
    protected int target; // 0: Ground, 1: Air, 2: Both, 3: Buildings
    protected boolean areaSplash;
    protected int count;


    public int getSpeed() {
        return speed;
    }

    public int getTarget() {
        return target;
    }

    public boolean isAreaSplash() {
        return areaSplash;
    }

    public int getCount() {
        return count;
    }

}
