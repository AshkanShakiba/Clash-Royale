public abstract class Spell extends Card {
    protected double radius;
    protected double duration;
    protected int areaDamage;

    public double getRadius() {
        return radius;
    }

    public double getDuration() {
        return duration;
    }

    public int getAreaDamage() {
        return areaDamage;
    }
}
