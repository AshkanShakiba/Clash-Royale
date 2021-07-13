public abstract class Troop extends Card {
    protected int hp;
    protected int damage;
    protected double hitSpeed;
    protected int speed; // 2: Slow, 3: Medium, 4: Fast
    protected int target; // 0: Ground, 1: Air, 2: Both, 3: Buildings
    protected double range; // 0: Melee
    protected boolean areaSplash;
    protected int count;
}
