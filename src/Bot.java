import java.security.SecureRandom;
import java.util.ArrayList;

public class Bot {
    private Game game;
    private double elixir;
    private Card nextCard;
    private ArrayList<Card> cards;
    private SecureRandom random;

    public Bot(Game game){
        elixir=4;
        this.game=game;
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
        Card card=cards.get(random.nextInt(8));
        if(elixir<card.getCost()) return;
        int X = random.nextInt(18);
        int Y = random.nextInt(14);
        User user=new User();
        Warrior warrior = card.getWarrior(user, X, Y);
        game.getTeamsMap().put(warrior, 0);
        game.getMap()[X][Y + 14] = warrior;
        game.getWarriorsInTheMap().add(warrior);
        System.out.println("***"+card.name()+"***");
        warrior.buildImageView("red");
        game.getMiddlePane().getChildren().add(warrior.imageView);
        elixir -= card.getCost();
        Game.playAudio(card.getAudio());
    }

}
