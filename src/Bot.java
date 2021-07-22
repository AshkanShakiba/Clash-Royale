import java.util.ArrayList;
import java.util.Random;

public class Bot {
    private Game game;
    private int level;
    private double elixir;
    private Card nextCard;
    private ArrayList<Card> cards;
    private Random random;
    private User user;

    public Bot(Game game, int level) {
        elixir = 4;
        this.game = game;
        this.level = level;
        cards = new ArrayList<>();
        random = new Random();
        for (int i = 0; i < 8; i++) {
            Card card = Main.getUsers().get(0).getCards().get(random.nextInt(12));
            while (cards.contains(card))
                card = Main.getUsers().get(0).getCards().get(random.nextInt(12));
            cards.add(card);
            System.out.println("**** " + card.name() + " ****");
        }
        if (level == 1) {
            user = new User(1);
        }
        if (level == 2) {
            user = new User(3);
        }
        if (level == 3) {
            user = new User(5);
        }
    }

    public void increaseElixir(double added) {
        if (elixir < 10)
            elixir += added;
    }

    public void move() {
        switch (level) {
            case 1:
                move1();
                break;
            case 2:
                move2();
                break;
            case 3:
                move3();
        }
    }

    private void move1() {
        Card card = cards.get(random.nextInt(8));

        if (elixir < card.getCost()) return;

        int x = random.nextInt(18);
        int y = random.nextInt(14) - 18;

        putWarriorLogic(card, x, y, 1);
    }

    private void move2() {
        Card card = cards.get(random.nextInt(8));

        if (elixir < card.getCost()) return;

        int y, x = random.nextInt(18);

        if (card == Card.ARROWS || card == Card.FIREBALL) {
            y = random.nextInt(14) - 4;
        } else {
            y = random.nextInt(14) - 18;
        }

        putWarriorLogic(card, x, y, 1);
    }

    private void move3() {
        Card card = cards.get(random.nextInt(8));

        ArrayList<Warrior> warriors = game.getPlayerWarriors();
        Warrior warrior = warriors.get(random.nextInt(warriors.size()));

        if (warrior instanceof Cannon) {
            card = Card.FIREBALL;
        }
        if (warrior instanceof Giant) {
            card = Card.BARBARIANS;
        }
        if (warrior instanceof BabyDragon) {
            card = Card.BABYDRAGON;
        }
        if (warrior instanceof Archers) {
            card = Card.ARROWS;
        }
        if (warrior instanceof Barbarians) {
            card = Card.VALKYRIE;
        }
        if (warrior instanceof MiniPekka) {
            card = Card.ARCHERS;
        }

        if (elixir < card.getCost()) return;

        int x = warrior.getArrayX();
        int y = warrior.getArrayY();

        if (y > -4 && card != Card.ARROWS && card != Card.FIREBALL) {
            y = -4;
        }

        putWarriorLogic(card, x, y, 1);
    }


    public void putWarriorLogic(Card card, int X, int Y, int team) {

        Warrior warrior = card.getWarrior(user, X, Y);

        if (warrior instanceof Barbarians) {
            ArrayList<Warrior> toPut = new ArrayList<>();
            if (game.checkValidPoint(warrior, X, Y)) {
                toPut.add(warrior);
            }
            if (game.checkValidPoint(warrior, X + 1, Y)) {
                warrior = card.getWarrior(user, X + 1, Y);
                toPut.add(warrior);
            }
            if (game.checkValidPoint(warrior, X, Y - 1)) {
                warrior = card.getWarrior(user, X, Y - 1);
                toPut.add(warrior);
            }
            if (game.checkValidPoint(warrior, X + 1, Y - 1)) {
                warrior = card.getWarrior(user, X + 1, Y - 1);
                toPut.add(warrior);
            }
            if (toPut.size() == 4) {
                for (Warrior wrr : toPut) {
                    putWarriorInThePoint(wrr, wrr.getArrayX(), wrr.arrayY, team);
                }
                elixir -= card.getCost();
                Game.playAudio(card.getAudio());
            }
        }
        if (warrior instanceof Archers) {
            ArrayList<Warrior> toPut = new ArrayList<>();
            if (game.checkValidPoint(warrior, X, Y)) {
                toPut.add(warrior);
            }
            if (game.checkValidPoint(warrior, X + 1, Y)) {
                warrior = card.getWarrior(user, X + 1, Y);
                toPut.add(warrior);
            }
            if (toPut.size() == 2) {
                for (Warrior wrr : toPut) {
                    putWarriorInThePoint(wrr, wrr.getArrayX(), wrr.arrayY, team);
                }
                elixir -= card.getCost();
                Game.playAudio(card.getAudio());
            }
        } else if (game.checkValidPoint(warrior, X, Y)) {
            putWarriorInThePoint(warrior, X, Y, team);
            Game.playAudio(card.getAudio());
            elixir -= card.getCost();
        }
    }

    public void putWarriorInThePoint(Warrior warrior, int X, int Y, int team) {
        game.getWarriorsInTheMap().add(warrior);
        game.getTeamsMap().put(warrior, team);
        game.getBuildingBuiltTime().put(warrior, game.getRound());

        game.getEndOfFaze1Warrior().put(warrior, false);
        //map[X][Y + 10] = warrior;
        if (warrior instanceof Arrows) {
            if (X < 9) {
                warrior.buildImageView("red left");
            } else {
                warrior.buildImageView("red right");
            }
        } else {
            warrior.buildImageView("red");
        }
        game.getMiddlePane().getChildren().add(warrior.imageView);
        System.out.println(warrior.toString() + " at (" + X + "," + (Y) + ")");

    }

}
