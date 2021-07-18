import javafx.scene.image.ImageView;

public class BabyDragon extends Troop {
    public BabyDragon(User user,int x,int y){
        this.arrayX=x;
        this.arrayY =y;
        switch (user.getLevel()){
            case 1:
                hp = 800;
                damage = 100;
                break;
            case 2:
                hp = 880;
                damage = 110;
                break;
            case 3:
                hp = 968;
                damage = 121;
                break;
            case 4:
                hp = 1064;
                damage = 133;
                break;
            case 5:
                hp = 1168;
                damage = 146;
        }
        hitSpeed = 1.8;
        speed = 4;
        target = 2;
        range = 3;
        areaSplash = true;
        count = 1;
        image = "assets/babyDragon.png";
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
        return "BabyDragon";
    }
}
