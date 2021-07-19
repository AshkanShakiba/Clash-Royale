public abstract class RealWarriors extends Warrior{

    protected int hp;
    protected int damage;
    protected double hitSpeed;


    public void setHp(int hp) {
        this.hp = hp;
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
