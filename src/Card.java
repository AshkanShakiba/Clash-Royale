import javafx.scene.image.Image;

public abstract class Card {
    protected int cost;
    protected Image image;

    public int getCost() {
        return cost;
    }

    public Image getImage() {
        return image;
    }
}
