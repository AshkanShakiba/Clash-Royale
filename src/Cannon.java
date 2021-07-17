import javafx.scene.image.Image;

public class Cannon extends Building {
    public Cannon(User user,double x,double y) {
        this.x=x;
        this.y=y;
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
        hitSpeed = 0.8;
        target = 0;
        range = 5.5;
        lifetime = 30;
        image = "assets/cannon.png";
    }

    @Override
    public String toString() {
        return "Cannon";
    }
}
