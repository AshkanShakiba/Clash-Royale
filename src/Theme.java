import javafx.scene.image.Image;

public enum Theme {
    BARBARIAN,
    BONE,
    BUILDER,
    CHAMPION,
    DARK,
    DEFAULT,
    GOBLIN,
    ICE,
    JUNGLE,
    SPELL;

    private Image image;

    Theme(){
        image=new Image("themes/"+name()+".png");
    }

    public Image getImage() {
        return image;
    }
}
