import javafx.scene.image.Image;

/**
 * The type Arrows.
 */
public class Arrows extends DamagingSpells {
    private String imageRedLeft;
    private String imageRedRight;
    private String imageBlueLeft;
    private String imageBlueRight;

    /**
     * Instantiates new Arrows.
     *
     * @param user the user
     * @param x    the x
     * @param y    the y
     */
    public Arrows(User user, int x, int y) {
        this.arrayX = x;
        this.arrayY = y;
        switch (user.getLevel()) {
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
        range = 4;
        imageBlue = "sprites/ArrowsBlue.gif";
        imageRed = "sprites/ArrowsRed.gif";
        imageWidth = 50;
        imageHeight = 50;
        duration = 0;

        imageRedLeft = "sprites/ArrowsRedLeft.png";
        imageRedRight = "sprites/ArrowsRedRight.png";
        imageBlueLeft = "sprites/ArrowsBlueLeft.png";
        imageBlueRight = "sprites/ArrowsBlueRight.png";
    }

    @Override
    public String toString() {
        return "Arrows";
    }

    @Override
    public void buildImageView(String direction) {
        if (direction.contains("red")) {
            super.buildImageView("red");
            if (direction.contains("left")) {
                imageView.setImage(new Image(imageRedLeft));
            }
            if (direction.contains("right")) {
                imageView.setImage(new Image(imageRedRight));
            }
        }
        if (direction.contains("blue")) {
            super.buildImageView("blue");
            if (direction.contains("left")) {
                imageView.setImage(new Image(imageBlueLeft));
            }
            if (direction.contains("right")) {
                imageView.setImage(new Image(imageBlueRight));
            }
        }
    }
}
