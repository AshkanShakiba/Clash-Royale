/**
 * The type Inferno tower.
 */
public class InfernoTower extends Building {
    private int maxDamage;
    private int baseDamage;

    /**
     * Instantiates a new Inferno tower.
     *
     * @param user the user
     * @param x    the x
     * @param y    the y
     */
    public InfernoTower(User user, int x, int y) {
        this.arrayX = x;
        this.arrayY = y;
        switch (user.getLevel()) {
            case 1:
                hp = 800;
                damage = 20;
                maxDamage = 400;
                break;
            case 2:
                hp = 880;
                damage = 22;
                maxDamage = 440;
                break;
            case 3:
                hp = 968;
                damage = 24;
                maxDamage = 484;
                break;
            case 4:
                hp = 1064;
                damage = 26;
                maxDamage = 532;
                break;
            case 5:
                hp = 1168;
                maxDamage = 584;
                damage = 29;
        }
        hitSpeed = 0.5;
        target = 2;
        range = 6;
        lifetime = 40;
        baseDamage = damage;
        zone = 0;
        imageBlue = "sprites/InfernoTowerBlue.png";
        imageRed = "sprites/InfernoTowerRed.png";
        imageWidth = 50;
        imageHeight = 75;
    }


    /**
     * Gets max damage.
     *
     * @return the max damage
     */
    public int getMaxDamage() {
        return maxDamage;
    }

    /**
     * Gets base damage.
     *
     * @return the base damage
     */
    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public String toString() {
        return "InfernoTower";
    }

    @Override
    public void buildImageView(String color) {
        super.buildImageView(color);
        imageView.setY(mapY - 50);
    }
}
