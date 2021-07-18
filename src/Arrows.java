import javafx.scene.image.ImageView;

public class Arrows extends Spell {
    public Arrows(User user,int x,int y){
        this.arrayX=x;
        this.arrayY =y;
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
        image = "assets/arrows.png";

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
        return "Arrows";
    }
}
