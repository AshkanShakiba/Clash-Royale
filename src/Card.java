public enum Card {
    BARBARIANS(5),
    ARCHERS(3),
    BABYDRAGON(4),
    WIZARD(5),
    MINIPEKKA(4),
    GIANT(5),
    VALKYRIE(4),
    RAGE(3),
    FIREBALL(4),
    ARROWS(3),
    CANNON(6),
    INFERNOTOWER(5);

    private int cost;
    private String image;
    private String audio;

    Card(int cost) {
        this.cost = cost;
        image = "assets/" + this.name() + ".png";
        audio = "audios/" + this.name() + ".mp3";
    }

    public int getCost() {
        return cost;
    }

    public String getImage() {
        return image;
    }

    public String getAudio() {
        return audio;
    }

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
