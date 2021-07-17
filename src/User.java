import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private String username;
    private int xp;
    private int level;
    private ArrayList<Card> cards;
    private Card[] currentCards;
    private SecureRandom random;

    {
        cards = new ArrayList<>();
        currentCards = new Card[8];
        random = new SecureRandom();
        username = "";

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

    public User(String username, int xp) {
        this.username = username;
        this.xp = xp;
    }

    public User(String username, int xp, String[] currentCards ){
        this(username, xp);
        int i = 0;
        for(String cardName : currentCards){
            for(Card card : cards){
                if(card.toString().equalsIgnoreCase(cardName)){
                    this.currentCards[i] = card;
                }
            }
            i++;
        }

    }

    public Card[] getCurrentCards() {
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


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", currentCards=" + Arrays.toString(currentCards) +
                '}';
    }
}
