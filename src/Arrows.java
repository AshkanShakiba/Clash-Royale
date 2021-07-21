import javafx.scene.image.ImageView;

public class Arrows extends DamagingSpells{
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
        imageBlue = "sprites/ArrowsBlue.gif";
        imageRed = "sprites/ArrowsRed.gif";
        imageWidth=50;
        imageHeight=50;
        duration = 0.125;
    }
    @Override
    public String toString() {
        return "Arrows";
    }
}
