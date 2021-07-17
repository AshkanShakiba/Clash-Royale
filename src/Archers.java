import javafx.scene.image.Image;

public class Archers extends Troop {
    public Archers(User user) {
        switch (user.getLevel()) {
            case 1:
                hp = 125;
                damage = 33;
                break;
            case 2:
                hp = 127;
                damage = 44;
                break;
            case 3:
                hp = 151;
                damage = 48;
                break;
            case 4:
                hp = 166;
                damage = 53;
                break;
            case 5:
                hp = 182;
                damage = 58;
        }
        hitSpeed = 1.2;
        speed = 3;
        target = 2;
        range = 5;
        areaSplash = false;
        count = 2;
        cost = 3;
        image = "assets/archers.png";
    }

    @Override
    public String toString() {
        return "Archers";
    }
}
