import javafx.scene.image.Image;

public class InfernoTower extends Building {
    public InfernoTower(User user) {
        switch (user.getLevel()) {
            case 1:
                hp = 800;
                damage = 20;
                break;
            case 2:
                hp = 880;
                damage = 22;
                break;
            case 3:
                hp = 968;
                damage = 24;
                break;
            case 4:
                hp = 1064;
                damage = 26;
                break;
            case 5:
                hp = 1168;
                damage = 29;
        }
        hitSpeed = 0.4;
        target = 2;
        range = 6;
        lifetime = 40;
        cost = 5;
        image = "assets/infernoTower.png";
    }
}
