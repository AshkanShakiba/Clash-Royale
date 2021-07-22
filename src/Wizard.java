/**
 * The type Wizard.
 */
public class Wizard extends Troop {
    /**
     * Instantiates a new Wizard.
     *
     * @param user the user
     * @param x    the x
     * @param y    the y
     */
    public Wizard(User user, int x, int y) {
        this.arrayX = x;
        this.arrayY = y;
        switch (user.getLevel()) {
            case 1:
                hp = 340;
                damage = 130;
                break;
            case 2:
                hp = 374;
                damage = 143;
                break;
            case 3:
                hp = 411;
                damage = 157;
                break;
            case 4:
                hp = 452;
                damage = 172;
                break;
            case 5:
                hp = 496;
                damage = 189;
        }
        hitSpeed = 1.75;
        speed = 3;
        target = 2;
        range = 5;
        areaSplash = true;
        count = 1;
        zone = 0;
        imageBlue = "sprites/WizardBlue.gif";
        imageRed = "sprites/WizardRed.gif";
        imageWidth = 80;
        imageHeight = 80;
    }

    @Override
    public String toString() {
        return "Wizard";
    }
}
