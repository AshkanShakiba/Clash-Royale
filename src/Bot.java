import java.security.SecureRandom;
import java.util.ArrayList;

public class Bot {
    private Game game;
    private int level;
    private double elixir;
    private Card nextCard;
    private ArrayList<Card> cards;
    private SecureRandom random;

    public Bot(Game game,int level){
        elixir=4;
        this.game=game;
        this.level=level;
        cards=new ArrayList<>();
        random=new SecureRandom();
        for(int i=0;i<8;i++){
            Card card=Main.getUsers().get(0).getCards().get(random.nextInt(12));
            while(cards.contains(card))
                card=Main.getUsers().get(0).getCards().get(random.nextInt(12));
            cards.add(card);
        }
    }

    public void increaseElixir(){
        if(elixir<10)
            elixir+=0.125;
    }

    public void move(){
        switch (level){
            case 1:
                move1();
                break;
            case 2:
                move2();
                break;
        }
    }

    private void move1(){
        Card card=cards.get(random.nextInt(8));
        putCard(card);
    }

    private void move2(){
        Card card=cards.get(random.nextInt(8));
        ArrayList<Warrior> warriors=game.getPlayerWarriors();
        for(Warrior warrior:warriors){
            if(warrior instanceof Giant){
                card=Card.BARBARIANS;
            }
            if(warrior instanceof BabyDragon){
                card=Card.BABYDRAGON;
            }
            if(warrior instanceof Barbarians){
                card=Card.VALKYRIE;
            }
            if(warrior instanceof MiniPekka){
                card=Card.ARCHERS;
            }
            if(warrior instanceof Cannon){
                card=Card.FIREBALL;
            }
            putCard(card,warrior.getArrayX(),warrior.getArrayY());
        }
    }

    private void putCard(Card card){
        if(elixir<card.getCost()) return;
        int X = random.nextInt(18);
        int Y = random.nextInt(14);
        User user=new User();
        Warrior warrior = card.getWarrior(user, X, Y-14);
        game.getTeamsMap().put(warrior, 1);
        game.getMap()[X][Y] = warrior;
        game.getWarriorsInTheMap().add(warrior);
        System.out.println("***"+card.name()+"***");
        warrior.buildImageView("red");
        game.getMiddlePane().getChildren().add(warrior.imageView);
        elixir -= card.getCost();
        Game.playAudio(card.getAudio());
    }

    private void putCard(Card card,int x,int y){
        if(elixir<card.getCost()) return;
        User user=new User();
        Warrior warrior = card.getWarrior(user, x, y);
        game.getTeamsMap().put(warrior, 1);
        game.getMap()[x][y] = warrior;
        game.getWarriorsInTheMap().add(warrior);
        System.out.println("***"+card.name()+"***");
        warrior.buildImageView("red");
        game.getMiddlePane().getChildren().add(warrior.imageView);
        elixir -= card.getCost();
        Game.playAudio(card.getAudio());
    }

}
