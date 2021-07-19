public abstract class Building extends RealWarriors {
    protected int target; // 0: Ground, 1: Air, 2: Both, 3: Buildings
    protected double range; // 0: Melee
    protected int lifetime;


    public int getTarget() {
        return target;
    }

    public double getRange() {
        return range;
    }

    public int getLifetime() {
        return lifetime;
    }
}
