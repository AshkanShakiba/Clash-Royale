import javafx.scene.image.ImageView;

public class Rage extends Spell {
    public Rage(User user, int x, int y) {
        this.arrayX = x;
        this.arrayY = y;
        switch (user.getLevel()) {
            case 1:
                duration = 6;
                break;
            case 2:
                duration = 6.5;
                break;
            case 3:
                duration = 7;
                break;
            case 4:
                duration = 7.5;
                break;
            case 5:
                duration = 8;
        }
        radius = 5;
        image = "sprites/Rage.png";

        imageView = new ImageView(image);
        imageView.setFitWidth(25);
        imageView.setFitHeight(25);
    }

    @Override
    public String toString() {
        return "Rage";
    }
}
