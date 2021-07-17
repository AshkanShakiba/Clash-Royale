import java.security.SecureRandom;
import java.util.ArrayList;

public class User {
    private int xp;
    private int level;
    private ArrayList<Card> cards;
    private ArrayList<Card> currentCards;
    private SecureRandom random;

    {
        cards = new ArrayList<>();
        currentCards = new ArrayList<>();
        random = new SecureRandom();

        cards.add(Card.BARBARIANS);
        cards.add(Card.ARCHERS);
        cards.add(Card.BABYDRAGON);
        cards.add(Card.WIZARD);
        cards.add(Card.MINIPEKKA);
        cards.add(Card.GIANT);
        cards.add(Card.VALKYRIE);
        cards.add(Card.RAGE);
        cards.add(Card.FIREBALL);
        cards.add(Card.ARROWS);
        cards.add(Card.CANNON);
        cards.add(Card.INFERNOTOWER);
    }

    public User() {
        xp = 0;
        level = 1;
    }


    public ArrayList<Card> getCurrentCards() {
        return currentCards;
    }

    public int getLevel() {
        return level;
    }

    public Card getRandomCard() {
        return cards.get(random.nextInt(8));
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
