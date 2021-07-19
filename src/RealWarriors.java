public abstract class RealWarriors extends Warrior{

    protected int hp;
    protected int damage;


    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }

    public boolean damage(int damage) {
        hp-=damage;
        if(hp<=0)
            return false;
        return true;
    }
}
