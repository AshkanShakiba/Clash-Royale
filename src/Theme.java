import javafx.scene.image.Image;

/**
 * The enum Theme.
 */
public enum Theme {
    /**
     * Barbarian theme.
     */
    BARBARIAN,
    /**
     * Bone theme.
     */
    BONE,
    /**
     * Builder theme.
     */
    BUILDER,
    /**
     * Champion theme.
     */
    CHAMPION,
    /**
     * Dark theme.
     */
    DARK,
    /**
     * Default theme.
     */
    DEFAULT,
    /**
     * Goblin theme.
     */
    GOBLIN,
    /**
     * Ice theme.
     */
    ICE,
    /**
     * Jungle theme.
     */
    JUNGLE,
    /**
     * Spell theme.
     */
    SPELL;

    private Image icon;
    private Image image;

    Theme() {
        icon = new Image("themes/" + name() + "..png");
        image = new Image("themes/" + name() + ".png");
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * Gets icon.
     *
     * @return the icon
     */
    public Image getIcon() {
        return icon;
    }
}
