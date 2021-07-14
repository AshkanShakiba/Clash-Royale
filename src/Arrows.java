import javafx.scene.image.Image;

public class Arrows extends Spell {
    public Arrows(User user){
        switch (user.getLevel()){
            case 1:
                areaDamage = 144;
                break;
            case 2:
                areaDamage = 156;
                break;
            case 3:
                areaDamage = 174;
                break;
            case 4:
                areaDamage = 189;
                break;
            case 5:
                areaDamage = 210;
        }
        radius = 4;
        cost = 3;
        image = new Image("assets/arrows.png");
    }
}
