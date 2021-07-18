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
        image = "sprites/BarbariansBlue.gif";

        imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        mapX = arrayX * 17.44 + 25;
        mapY = arrayY * 14.29 + 240 - 10;
        imageView.setX(mapX);
        imageView.setY(mapY);
    }

    @Override
    public String toString() {
        return "Barbarians";
    }
}
