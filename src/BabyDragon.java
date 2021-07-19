import javafx.scene.image.ImageView;

public class BabyDragon extends Troop {
    public BabyDragon(User user, int x, int y) {
        this.arrayX = x;
        this.arrayY = y;
        switch (user.getLevel()) {
            case 1:
                hp = 800;
                damage = 100;
                break;
            case 2:
                hp = 880;
                damage = 110;
                break;
            case 3:
                hp = 968;
                damage = 121;
                break;
            case 4:
                hp = 1064;
                damage = 133;
                break;
            case 5:
                hp = 1168;
                damage = 146;
        }
        hitSpeed = 2.0;
        speed = 4;
        target = 2;
        range = 3;
        areaSplash = true;
        count = 1;
        imageBlue = "sprites/BabyDragonBlue.gif";
        imageRed = "sprites/BabyDragonRed.gif";
        imageWidth=90;
        imageHeight=90;
    }

    @Override
    public String toString() {
        return "BabyDragon";
    }
}
