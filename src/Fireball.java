import javafx.scene.image.Image;

public class Fireball extends Spell {
    public Fireball(User user){
        switch (user.getLevel()){
            case 1:
                areaDamage = 325;
                break;
            case 2:
                areaDamage = 357;
                break;
            case 3:
                areaDamage = 393;
                break;
            case 4:
                areaDamage = 432;
                break;
            case 5:
                areaDamage = 474;
        }
        radius = 2.5;
        cost = 4;
        image = new Image("assets/fireball.png");
    }
}
