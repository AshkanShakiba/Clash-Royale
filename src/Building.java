/**
 * The type Building.
 */
public abstract class Building extends RealWarrior {
    /**
     * The Lifetime.
     */
    protected int lifetime;

    /**
     * Gets lifetime.
     *
     * @return the lifetime
     */
    public int getLifetime() {
        return lifetime;
    }

    @Override
    public int getHp() {
        return hp;
    }
}
