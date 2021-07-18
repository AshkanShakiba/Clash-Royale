import javafx.scene.image.ImageView;

public abstract class Warrior {
    protected int arrayX;
    protected int arrayY;
    protected double mapX;
    protected double mapY;
    protected String image;
    protected ImageView imageView;
    protected boolean isAlive = true;


    public double getX() {
        return arrayX;
    }

    public int getArrayY() {
        return arrayY;
    }

    public int getArrayX() {
        return arrayX;
    }

    public String getImage() {
        return image;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setArrayX(int arrayX) {
        this.arrayX = arrayX;
    }

    public void setArrayY(int arrayY) {
        this.arrayY = arrayY;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void buildImageView(){
//        imageView = new ImageView(image);
//        imageView.setFitWidth(50);
//        imageView.setFitHeight(50);
//        mapX = arrayX*17.44 + 25;
//        mapY = arrayY *14.29 + 240 -10;
//        imageView.setX(mapX);
//        imageView.setY(mapY);
    }


}
