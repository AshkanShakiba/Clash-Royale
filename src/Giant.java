import javafx.scene.image.ImageView;

public class Giant extends Troop {
    public Giant(User user,int x,int y){
        this.arrayX=x;
        this.arrayY =y;
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

        imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        mapX = arrayX*17.44 + 25;
        mapY = arrayY *14.29 + 240 -10;
        imageView.setX(mapX);
        imageView.setY(mapY);
    }

    @Override
    public String toString() {
        return "Giant";
    }
}
