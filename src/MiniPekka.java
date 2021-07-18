import javafx.scene.image.ImageView;

public class MiniPekka extends Troop {
    public MiniPekka(User user,int x,int y){
        this.arrayX=x;
        this.arrayY =y;
        switch (user.getLevel()){
            case 1:
                hp = 600;
                damage = 325;
                break;
            case 2:
                hp = 660;
                damage = 357;
                break;
            case 3:
                hp = 726;
                damage = 393;
                break;
            case 4:
                hp = 798;
                damage = 432;
                break;
            case 5:
                hp = 876;
                damage = 474;
        }
        hitSpeed = 1.8;
        speed = 4;
        target = 0;
        range = 0;
        areaSplash = false;
        count = 1;
        image = "sprites/MiniPekkaBlue.gif";

        imageView = new ImageView(image);
        imageView.setFitWidth(60);
        imageView.setFitHeight(60);
        mapX = arrayX*17.44 + 25;
        mapY = arrayY *14.29 + 240 -10;
        imageView.setX(mapX);
        imageView.setY(mapY);
    }

    @Override
    public String toString() {
        return "MiniPekka";
    }
}
