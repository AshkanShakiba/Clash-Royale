public abstract class Building extends RealWarriors {
    protected int target; // 0: Ground, 1: Air, 2: Both, 3: Buildings
    protected int lifetime;


    public int getTarget() {
        return target;
    }

    public int getLifetime() {
        return lifetime;
    }
}
