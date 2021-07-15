import java.security.SecureRandom;

public class User {
    private int xp;
    private int level;
    private Card[] cards;
    private SecureRandom random;

    public User() {
        xp = 0;
        level = 1;
        cards = new Card[8];
        random = new SecureRandom();
    }

    public int getLevel() {
        return level;
    }

    public Card getRandomCard() {
        return cards[random.nextInt(8)];
    }
}
