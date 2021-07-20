public abstract class RealWarriors extends Warrior{

    protected int hp;
    protected int damage;
    protected double hitSpeed;
    protected double range;
    protected int target; // 0: Ground, 1: Air, 2: Both, 3: Buildings
    protected int zone ; // 0: Ground, 1: Air


    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getTarget() {
        return target;
    }

    public int getZone() {
        return zone;
    }

    public double getRange() {
        return range;
    }

    public int getHp() {
        return hp;
    }

    public double getHitSpeed() {
        return hitSpeed;
    }

    public int getDamage() {
        return damage;
    }

    public void damage(int damage) {
        hp-=damage;
        if(hp<=0)
            setAlive(false);
    }
}
