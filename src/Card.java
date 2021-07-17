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

    Card(int cost) {
        this.cost = cost;
        image = "assets/" + this.name() + ".png";
    }

    public String getImage() {
        return image;
    }

    public Warrior getWarrior(User user) {
        if (this == BARBARIANS)
            return new Barbarians(user);
        if (this == ARCHERS)
            return new Archers(user);
        if (this == BABYDRAGON)
            return new BabyDragon(user);
        if (this == WIZARD)
            return new Wizard(user);
        if (this == MINIPEKKA)
            return new MiniPekka(user);
        if (this == GIANT)
            return new Giant(user);
        if (this == VALKYRIE)
            return new Valkyrie(user);
        if (this == RAGE)
            return new Rage(user);
        if (this == FIREBALL)
            return new Fireball(user);
        if (this == ARROWS)
            return new Arrows(user);
        if (this == CANNON)
            return new Cannon(user);
        if (this == INFERNOTOWER)
            return new InfernoTower(user);
        return null;
    }

}
