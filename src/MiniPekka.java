/**
 * The type Mini pekka.
 */
public class MiniPekka extends Troop {
    /**
     * Instantiates a new Mini pekka.
     *
     * @param user the user
     * @param x    the x
     * @param y    the y
     */
    public MiniPekka(User user, int x, int y) {
        this.arrayX = x;
        this.arrayY = y;
        switch (user.getLevel()) {
            case 1:
                hp = 600;
                damage = 325;
                break;
            case 2:
                hp = 660;
                damage = 357;
                break;
            case 3:
                hp = 726;
                damage = 393;
                break;
            case 4:
                hp = 798;
                damage = 432;
                break;
            case 5:
                hp = 876;
                damage = 474;
        }
        hitSpeed = 1.75;
        speed = 4;
        target = 0;
        range = 0;
        areaSplash = false;
        count = 1;
        zone = 0;
        imageBlue = "sprites/MiniPekkaBlue.gif";
        imageRed = "sprites/MiniPekkaRed.gif";
        imageWidth = 60;
        imageHeight = 60;
    }

    @Override
    public String toString() {
        return "MiniPekka";
    }
}
