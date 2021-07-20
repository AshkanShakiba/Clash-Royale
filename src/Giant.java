import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Giant extends Troop {
    private static int[] damageArray = new int[]{126, 138, 152, 167, 183};
    private static String imageBluePath = "sprites/GiantBlue.gif";
    private static String imageRedPath = "sprites/GiantRed.gif";

    public Giant(User user, int x, int y) {
        this.arrayX = x;
        this.arrayY = y;
        switch (user.getLevel()) {
            case 1:
                hp = 2000;
                damage = damageArray[0];
                break;
            case 2:
                hp = 2200;
                damage = damageArray[1];
                break;
            case 3:
                hp = 2420;
                damage = damageArray[2];
                break;
            case 4:
                hp = 2660;
                damage = damageArray[3];
                break;
            case 5:
                hp = 2920;
                damage = damageArray[4];
        }
        hitSpeed = 1.5;
        speed = 2;
        target = 3;
        range = 0;
        areaSplash = false;
        count = 1;
        imageBlue = imageBluePath;
        imageRed = imageRedPath;
        imageWidth = 120;
        imageHeight = 120;
    }

    @Override
    public String toString() {
        return "Giant";
    }

    public static void upgrade() {
        damageArray = new int[]{252, 276, 304, 334, 366};
        imageBluePath = "sprites/RoyalGiantBlue.gif";
        imageRedPath = "sprites/RoyalGiantRed.gif";
    }
}
