import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The type Warrior.
 */
public abstract class Warrior {
    /**
     * The Array x.
     */
    protected int arrayX;
    /**
     * The Array y.
     */
    protected int arrayY;
    /**
     * The Map x.
     */
    protected double mapX;
    /**
     * The Map y.
     */
    protected double mapY;
    /**
     * The Image width.
     */
    protected int imageWidth;
    /**
     * The Image height.
     */
    protected int imageHeight;
    /**
     * The Image blue.
     */
    protected String imageBlue;
    /**
     * The Image red.
     */
    protected String imageRed;
    /**
     * The Image view.
     */
    protected ImageView imageView;
    /**
     * The Is alive.
     */
    protected boolean isAlive = true;
    /**
     * The Range.
     */
    protected double range;


    /**
     * Gets range.
     *
     * @return the range
     */
    public double getRange() {
        return range;
    }

    /**
     * Gets array y.
     *
     * @return the array y
     */
    public int getArrayY() {
        return arrayY;
    }

    /**
     * Sets array y.
     *
     * @param arrayY the array y
     */
    public void setArrayY(int arrayY) {
        this.arrayY = arrayY;
    }

    /**
     * Gets array x.
     *
     * @return the array x
     */
    public int getArrayX() {
        return arrayX;
    }

    /**
     * Sets array x.
     *
     * @param arrayX the array x
     */
    public void setArrayX(int arrayX) {
        this.arrayX = arrayX;
    }

    /**
     * Gets image view.
     *
     * @return the image view
     */
    public ImageView getImageView() {
        return imageView;
    }

    /**
     * Sets image view.
     *
     * @param imageView the image view
     */
    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    /**
     * Is alive boolean.
     *
     * @return the boolean
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Sets alive.
     *
     * @param alive the alive
     */
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    /**
     * Build image view.
     *
     * @param color the color
     */
    public void buildImageView(String color) {
        imageView = new ImageView();
        if (color.equals("blue"))
            imageView.setImage(new Image(imageBlue));
        if (color.equals("red"))
            imageView.setImage(new Image(imageRed));
        imageView.setFitWidth(imageWidth);
        imageView.setFitHeight(imageHeight);
        mapX = arrayX * 17.44 + 17.44;
        mapY = arrayY * 14.29 + 220;
        imageView.setX(mapX);
        imageView.setY(mapY);
    }


}
