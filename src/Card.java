import javafx.scene.image.Image;

public abstract class Card {
    protected int cost;
    protected String image;

    public int getCost() {
        return cost;
    }

    public String getImage() {
        return image;
    }
}
