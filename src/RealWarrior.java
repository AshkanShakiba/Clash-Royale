/**
 * The type Real warrior.
 */
public abstract class RealWarrior extends Warrior {

    /**
     * The Hp.
     */
    protected int hp;
    /**
     * The Damage.
     */
    protected int damage;
    /**
     * The Hit speed.
     */
    protected double hitSpeed;
    /**
     * The Target.
     */
    protected int target; // 0: Ground, 1: Air, 2: Both, 3: Buildings
    /**
     * The Zone.
     */
    protected int zone; // 0: Ground, 1: Air

    /**
     * Gets target.
     *
     * @return the target
     */
    public int getTarget() {
        return target;
    }

    /**
     * Gets zone.
     *
     * @return the zone
     */
    public int getZone() {
        return zone;
    }

    /**
     * Gets hp.
     *
     * @return the hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * Sets hp.
     *
     * @param hp the hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Gets hit speed.
     *
     * @return the hit speed
     */
    public double getHitSpeed() {
        return hitSpeed;
    }

    /**
     * Sets hit speed.
     *
     * @param hitSpeed the hit speed
     */
    public void setHitSpeed(double hitSpeed) {
        this.hitSpeed = hitSpeed;
    }

    /**
     * Gets damage.
     *
     * @return the damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Sets damage.
     *
     * @param damage the damage
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Damage.
     *
     * @param damage the damage
     */
    public void damage(int damage) {
        hp -= damage;
        if (hp <= 0)
            setAlive(false);
    }
}
