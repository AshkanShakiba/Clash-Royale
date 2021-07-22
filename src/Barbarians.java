/**
 * The type Barbarians.
 */
public class Barbarians extends Troop {
    private static int[] hpArray = new int[]{300, 330, 363, 438, 480};
    private static int[] damageArray = new int[]{75, 82, 90, 99, 109};

    private static double hitSpeedStatic = 1.5;
    private static int speedStatic = 3;

    private static String imageBluePath = "sprites/BarbariansBlue.gif";
    private static String imageRedPath = "sprites/BarbariansRed.gif";

    private static boolean isViki = false;
    private static boolean isQuick = false;

    /**
     * Instantiates new Barbarians.
     *
     * @param user the user
     * @param x    the x
     * @param y    the y
     */
    public Barbarians(User user, int x, int y) {
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
        hitSpeed = hitSpeedStatic;
        speed = speedStatic;
        target = 0;
        range = 0;
        areaSplash = false;
        count = 4;
        zone = 0;
        imageBlue = imageBluePath;
        imageRed = imageRedPath;
        imageWidth = 80;
        imageHeight = 80;
    }

    /**
     * Upgrade to viki.
     */
    public static void upgradeToViki() {
        hitSpeedStatic = 1.5;
        speedStatic = 3;

        hpArray = new int[]{450, 495, 545, 657, 720};
        damageArray = new int[]{113, 123, 135, 149, 164};

        imageBluePath = "sprites/VikiBarbariansBlue.gif";
        imageRedPath = "sprites/VikiBarbariansRed.gif";

        isViki = true;
        isQuick = false;
    }

    /**
     * Upgrade to quick.
     */
    public static void upgradeToQuick() {
        hitSpeedStatic = 3;
        speedStatic = 6;

        hpArray = new int[]{300, 330, 363, 438, 480};
        damageArray = new int[]{75, 82, 90, 99, 109};

        imageBluePath = "sprites/QuickBarbariansBlue.gif";
        imageRedPath = "sprites/QuickBarbariansRed.gif";

        isViki = false;
        isQuick = true;
    }

    /**
     * Is viki boolean.
     *
     * @return the boolean
     */
    public static boolean isViki() {
        return isViki;
    }

    /**
     * Is quick boolean.
     *
     * @return the boolean
     */
    public static boolean isQuick() {
        return isQuick;
    }

    @Override
    public String toString() {
        return "Barbarians";
    }
}
