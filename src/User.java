import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private String username;
    private int xp;
    private int level;
    private int title;
    private String league;
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
        title = 0;
        league = getLeague(title);
    }

    public User(int level) {
        xp = 0;
        title = 1;
        this.level = level;
        league = getLeague(title);
    }

    public User(String username, int xp) {
        this.username = username;
        this.xp = xp;
        if (xp < 300) {
            level = 1;
        } else if (xp < 500) {
            level = 2;
        } else if (xp < 900) {
            level = 3;
        } else if (xp < 1700) {
            level = 4;
        } else {
            level = 5;
        }
        league = getLeague(title);
    }

    public User(String username, int xp, String[] currentCards, int title) {
        this(username, xp);
        int i = 0;
        for (String cardName : currentCards) {
            for (Card card : cards) {
                if (card.toString().equalsIgnoreCase(cardName)) {
                    this.currentCards[i] = card;
                }
            }
            i++;
        }
        this.title = title;
        league = getLeague(title);
    }

    public Card[] getCurrentCards() {
        return currentCards;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public int getTitle() {
        return title;
    }

    public Card getRandomCard() {
        //return cards.get(random.nextInt(12)); // 8
        return currentCards[random.nextInt(8)];
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", currentCards=" + Arrays.toString(currentCards) +
                '}';
    }

    public void increaseXp(int addedXp) {
        xp += addedXp;
        if (xp < 300) {
            level = 1;
        } else if (xp < 500) {
            level = 2;
        } else if (xp < 900) {
            level = 3;
        } else if (xp < 1700) {
            level = 4;
        } else {
            level = 5;
        }
    }

    public void setXp(int xp){
       this.xp=xp;
        if (xp < 300) {
            level = 1;
        } else if (xp < 500) {
            level = 2;
        } else if (xp < 900) {
            level = 3;
        } else if (xp < 1700) {
            level = 4;
        } else {
            level = 5;
        }
    }

    public void increaseTitle(int addedTitle) {
        title += addedTitle;
        league = getLeague(title);
    }

    private String getLeague(int title) {
        String league = "";
        if (0 <= title && title <= 10) {
            league = "Goblins";
        }
        if (11 <= title && title <= 30) {
            league = "Archers";
        }
        if (31 <= title && title <= 100) {
            league = "Barbars";
        }
        if (101 <= title && title <= 300) {
            league = "Wizards";
        }
        if (301 <= title && title <= 1000) {
            league = "Princes";
        }
        if (1001 <= title) {
            league = "Legends";
        }
        league += " League";
        return league;
    }

    public String getLeague() {
        return league;
    }
}