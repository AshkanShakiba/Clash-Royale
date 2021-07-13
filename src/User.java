public class User {
    private int xp;
    private int level;
    private Card[] cards;

    public User() {
        xp = 0;
        level = 1;
        cards = new Card[8];
    }

    public int getLevel() {
        return level;
    }
}
