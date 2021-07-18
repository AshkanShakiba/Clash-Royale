import javafx.scene.image.ImageView;

public abstract class Warrior {
    protected double x;
    protected double y;
    protected String image;
    protected ImageView imageView;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getImage() {
        return image;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void buildImageView(){
        imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        imageView.setX(x*17.44 + 25);
        imageView.setY(y*14.29 + 240 -10);
    }
}
