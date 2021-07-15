import javafx.scene.image.Image;

public class Valkyrie extends Troop {
    public Valkyrie(User user){
        switch (user.getLevel()){
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
        cost = 4;
        image = "assets/valkyrie.png";
    }
}
