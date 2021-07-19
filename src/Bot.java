import java.util.ArrayList;

public class Bot {
    private double elixir;
    private ArrayList<Card> cards;

    public Bot(){
        elixir=4;
        cards=new ArrayList<>();
    }

    public void increaseElixir(){
        elixir+=0.125;
    }
}
