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

    private Image icon;
    private Image image;

    Theme() {
        icon = new Image("themes/" + name() + "..png");
        image = new Image("themes/" + name() + ".png");
    }

    public Image getImage() {
        return image;
    }

    public Image getIcon() {
        return icon;
    }
}
