import java.security.SecureRandom;
import java.util.ArrayList;

public class User {
    private int xp;
    private int level;
    private ArrayList<Card> cards;
    private SecureRandom random;

    public User() {
        xp = 0;
        level = 1;
        cards = new ArrayList<>();
        random = new SecureRandom();
        cards.add(new Archers(this));
        cards.add(new BabyDragon(this));
        cards.add(new Wizard(this));
        cards.add(new MiniPekka(this));
        cards.add(new Barbarians(this));
        cards.add(new InfernoTower(this));
        cards.add(new Arrows(this));
        cards.add(new Fireball(this));
    }

    public int getLevel() {
        return level;
    }

    public Card getRandomCard() {
        return cards.get(random.nextInt(8));
    }
}
