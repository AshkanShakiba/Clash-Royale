import javafx.scene.image.Image;

public class Rage extends Spell {
    public Rage(User user){
        switch (user.getLevel()){
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
        cost = 3;
        image = "assets/rage.png";
    }

    @Override
    public String toString() {
        return "Rage";
    }
}
