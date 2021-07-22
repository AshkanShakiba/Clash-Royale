/**
 * The type Queen tower.
 */
public class QueenTower extends Building {
    /**
     * Instantiates a new Queen tower.
     *
     * @param user the user
     * @param x    the x
     * @param y    the y
     */
    public QueenTower(User user, int x, int y) {
        this.arrayX = x;
        this.arrayY = y;
        switch (user.getLevel()) {
            case 1:
                hp = 1400;
                damage = 50;
                break;
            case 2:
                hp = 1512;
                damage = 54;
                break;
            case 3:
                hp = 1624;
                damage = 58;
                break;
            case 4:
                hp = 1750;
                damage = 62;
                break;
            case 5:
                hp = 1890;
                damage = 69;
        }
        hitSpeed = 0.75;
        target = 2;
        range = 7.5;
        zone = 0;
        lifetime = 180;
    }

    @Override
    public String toString() {
        return "QUEENTOWER";
    }
}
