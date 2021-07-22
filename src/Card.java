/**
 * The enum of Card.
 */
public enum Card {
    /**
     * Barbarians card.
     */
    BARBARIANS(5),
    /**
     * Archers card.
     */
    ARCHERS(3),
    /**
     * Babydragon card.
     */
    BABYDRAGON(4),
    /**
     * Wizard card.
     */
    WIZARD(5),
    /**
     * Minipekka card.
     */
    MINIPEKKA(4),
    /**
     * Giant card.
     */
    GIANT(5),
    /**
     * Valkyrie card.
     */
    VALKYRIE(4),
    /**
     * Rage card.
     */
    RAGE(3),
    /**
     * Fireball card.
     */
    FIREBALL(4),
    /**
     * Arrows card.
     */
    ARROWS(3),
    /**
     * Cannon card.
     */
    CANNON(6),
    /**
     * Infernotower card.
     */
    INFERNOTOWER(5);

    private int cost;
    private String image;
    private String audio;

    Card(int cost) {
        this.cost = cost;
        image = "assets/" + this.name() + ".png";
        audio = "audios/" + this.name() + ".mp3";
    }

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * Gets image.
     *
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * Gets audio.
     *
     * @return the audio
     */
    public String getAudio() {
        return audio;
    }

    /**
     * Gets warrior.
     *
     * @param user the user
     * @param x    the x
     * @param y    the y
     * @return the warrior
     */
    public Warrior getWarrior(User user, int x, int y) {
        if (this == BARBARIANS)
            return new Barbarians(user, x, y);
        if (this == ARCHERS)
            return new Archers(user, x, y);
        if (this == BABYDRAGON)
            return new BabyDragon(user, x, y);
        if (this == WIZARD)
            return new Wizard(user, x, y);
        if (this == MINIPEKKA)
            return new MiniPekka(user, x, y);
        if (this == GIANT)
            return new Giant(user, x, y);
        if (this == VALKYRIE)
            return new Valkyrie(user, x, y);
        if (this == RAGE)
            return new Rage(user, x, y);
        if (this == FIREBALL)
            return new Fireball(user, x, y);
        if (this == ARROWS)
            return new Arrows(user, x, y);
        if (this == CANNON)
            return new Cannon(user, x, y);
        if (this == INFERNOTOWER)
            return new InfernoTower(user, x, y);
        return null;
    }
}
