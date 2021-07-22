public abstract class Building extends RealWarrior {
    protected int lifetime;
    
    public int getLifetime() {
        return lifetime;
    }

    @Override
    public int getHp() {
        return hp;
    }
}
