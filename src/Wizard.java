import javafx.scene.image.ImageView;

public class Wizard extends Troop {
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
        image = "sprites/WizardBlue.gif";

        imageView = new ImageView(image);
        imageView.setFitWidth(90);
        imageView.setFitHeight(90);
    }

    @Override
    public String toString() {
        return "Wizard";
    }
}
