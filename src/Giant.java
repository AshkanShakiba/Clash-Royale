import javafx.scene.image.Image;

public class Giant extends Troop {
    public Giant(User user,double x,double y){
        this.x=x;
        this.y=y;
        switch (user.getLevel()){
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
        image = "assets/giant.png";
    }

    @Override
    public String toString() {
        return "Giant";
    }
}
