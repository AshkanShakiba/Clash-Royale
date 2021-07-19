import javafx.scene.image.ImageView;

public class Giant extends Troop {
    public Giant(User user, int x, int y) {
        this.arrayX = x;
        this.arrayY = y;
        switch (user.getLevel()) {
            case 1:
                hp = 2000;
                damage = 126;
                break;
            case 2:
                hp = 2200;
                damage = 138;
                break;
            case 3:
                hp = 2420;
                damage = 152;
                break;
            case 4:
                hp = 2660;
                damage = 167;
                break;
            case 5:
                hp = 2920;
                damage = 183;
        }
        hitSpeed = 1.5;
        speed = 2;
        target = 3;
        range = 0;
        areaSplash = false;
        count = 1;
        imageBlue = "sprites/GiantBlue.gif";
        imageRed = "sprites/GiantRed.gif";
        imageView.setFitWidth(120);
        imageView.setFitHeight(120);
    }

    @Override
    public String toString() {
        return "Giant";
    }
}
