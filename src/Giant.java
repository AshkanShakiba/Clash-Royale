/**
 * The type Giant.
 */
public class Giant extends Troop {
    private static int[] damageArray = new int[]{126, 138, 152, 167, 183};
    private static int[] hpArray = new int[]{2000, 2200, 2420, 2660, 2920};

    private static String imageBluePath = "sprites/GiantBlue.gif";
    private static String imageRedPath = "sprites/GiantRed.gif";

    private static boolean isRoyal = false;

    /**
     * Instantiates a new Giant.
     *
     * @param user the user
     * @param x    the x
     * @param y    the y
     */
    public Giant(User user, int x, int y) {
        this.arrayX = x;
        this.arrayY = y;
        switch (user.getLevel()) {
            case 1:
                hp = hpArray[0];
                damage = damageArray[0];
                break;
            case 2:
                hp = hpArray[1];
                damage = damageArray[1];
                break;
            case 3:
                hp = hpArray[2];
                damage = damageArray[2];
                break;
            case 4:
                hp = hpArray[3];
                damage = damageArray[3];
                break;
            case 5:
                hp = hpArray[4];
                damage = damageArray[4];
        }
        hitSpeed = 1.5;
        speed = 2;
        target = 3;
        range = 0;
        areaSplash = false;
        count = 1;
        zone = 0;
        imageBlue = imageBluePath;
        imageRed = imageRedPath;
        imageWidth = 120;
        imageHeight = 120;
    }

    /**
     * Upgrade.
     */
    public static void upgrade() {
        damageArray = new int[]{252, 276, 304, 334, 366};
        hpArray = new int[]{3000, 3300, 3630, 3990, 4380};
        imageBluePath = "sprites/RoyalGiantBlue.gif";
        imageRedPath = "sprites/RoyalGiantRed.gif";
        isRoyal = true;
    }

    /**
     * Is royal boolean.
     *
     * @return the boolean
     */
    public static boolean isRoyal() {
        return isRoyal;
    }

    @Override
    public String toString() {
        return "Giant";
    }

    @Override
    public void buildImageView(String color) {
        super.buildImageView(color);
        imageView.setX(mapX - 15);
        imageView.setY(mapY - 20);
    }
}
