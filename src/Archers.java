import javafx.scene.image.ImageView;

public class Archers extends Troop {
    public Archers(User user, int x, int y) {
        this.arrayX = x;
        this.arrayY = y;
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
        image = "sprites/ArchersBlue.gif";

        imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
    }

    @Override
    public String toString() {
        return "Archers";
    }

}
