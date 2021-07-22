/**
 * The type Cannon.
 */
public class Cannon extends Building {
    /**
     * Instantiates a new Cannon.
     *
     * @param user the user
     * @param x    the x
     * @param y    the y
     */
    public Cannon(User user, int x, int y) {
        this.arrayX = x;
        this.arrayY = y;
        switch (user.getLevel()) {
            case 1:
                hp = 380;
                damage = 60;
                break;
            case 2:
                hp = 418;
                damage = 66;
                break;
            case 3:
                hp = 459;
                damage = 72;
                break;
            case 4:
                hp = 505;
                damage = 79;
                break;
            case 5:
                hp = 554;
                damage = 87;
        }
        hitSpeed = 0.75;
        target = 0;
        range = 5.5;
        lifetime = 30;
        zone = 0;
        imageBlue = "sprites/CannonBlue.png";
        imageRed = "sprites/CannonRed.png";
        imageWidth = 50;
        imageHeight = 50;
    }

    @Override
    public String toString() {
        return "Cannon";
    }
}
