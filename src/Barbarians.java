import javafx.scene.image.ImageView;

public class Barbarians extends Troop {
    public Barbarians(User user, int x, int y) {
        this.arrayX = x;
        this.arrayY = y;
        switch (user.getLevel()) {
            case 1:
                hp = 300;
                damage = 75;
                break;
            case 2:
                hp = 330;
                damage = 82;
                break;
            case 3:
                hp = 363;
                damage = 90;
                break;
            case 4:
                hp = 438;
                damage = 99;
                break;
            case 5:
                hp = 480;
                damage = 109;
        }
        hitSpeed = 1.5;
        speed = 3;
        target = 0;
        range = 0;
        areaSplash = false;
        count = 4;
        zone = 0;
        imageBlue = "sprites/BarbariansBlue.gif";
        imageRed = "sprites/BarbariansRed.gif";
        imageWidth=80;
        imageHeight=80;
    }

    @Override
    public String toString() {
        return "Barbarians";
    }
}
