import javafx.scene.image.ImageView;

public class Valkyrie extends Troop {
    public Valkyrie(User user, int x, int y) {
        this.arrayX = x;
        this.arrayY = y;
        switch (user.getLevel()) {
            case 1:
                hp = 880;
                damage = 120;
                break;
            case 2:
                hp = 968;
                damage = 132;
                break;
            case 3:
                hp = 1064;
                damage = 145;
                break;
            case 4:
                hp = 1170;
                damage = 159;
                break;
            case 5:
                hp = 1284;
                damage = 175;
        }
        hitSpeed = 1.5;
        speed = 3;
        target = 0;
        range = 0;
        areaSplash = true;
        count = 1;
        image = "sprites/ValkyrieBlue.gif";

        imageView = new ImageView(image);
        imageView.setFitWidth(70);
        imageView.setFitHeight(70);
        mapX = arrayX * 17.44 + 25;
        mapY = arrayY * 14.29 + 240 - 10;
        imageView.setX(mapX);
        imageView.setY(mapY);
    }

    @Override
    public String toString() {
        return "Valkyrie";
    }
}
