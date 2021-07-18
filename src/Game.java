import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashSet;

public class Game {
    @FXML
    private AnchorPane leftPane;
    @FXML
    private AnchorPane middlePane;
    @FXML
    private AnchorPane rightPane;
    @FXML
    private GridPane cardsPane;
    @FXML
    private Button card0;
    @FXML
    private Button card1;
    @FXML
    private Button card2;
    @FXML
    private Button card3;
    @FXML
    private Button next;
    @FXML
    private Label nextLabel;
    @FXML
    private ProgressBar elixirBar;

    private User user;
    private double x, y;
    private double elixir;
    private Warrior[][] map;
    private boolean map2IsValid;
    private boolean map3IsValid;
    private Card nextCard;
    private int selectedCardIndex;
    private ArrayList<Card> availableCards;
    private HashSet<Warrior> warriorsInTheMap = new HashSet<>();

    private int round = 0;

    public void construct(User user) {
        elixir = 4;
        map = new Warrior[18][28];
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 28; j++) {
                map[i][j] = null;
            }
        }
        map2IsValid = true;
        map3IsValid = false;
        this.user = user;
        availableCards = new ArrayList<>();
        availableCards.add(getNextCard());
        availableCards.add(getNextCard());
        availableCards.add(getNextCard());
        availableCards.add(getNextCard());
        nextCard = getNextCard();
        selectedCardIndex = -1;
        //new Thread(new Updater(this)).start();
    }

    public void update() {
        card0.setStyle("-fx-background-image: url('" + availableCards.get(0).getImage() + "');");
        card1.setStyle("-fx-background-image: url('" + availableCards.get(1).getImage() + "');");
        card2.setStyle("-fx-background-image: url('" + availableCards.get(2).getImage() + "');");
        card3.setStyle("-fx-background-image: url('" + availableCards.get(3).getImage() + "');");
        next.setStyle("-fx-background-image: url('" + nextCard.getImage() + "');");

        if (elixir < 10) elixir += .125;
        elixirBar.setProgress(((int) elixir) / 10.0);

        for(Warrior warrior : warriorsInTheMap){
/*
            int firstSize = warriorsInTheMap.size();
            warrior.buildImageView();
            ImageView imageView  = warrior.getImageView();
            warriorsInTheMap.add(warrior);

            if(warriorsInTheMap.size() > firstSize) {
                middlePane.getChildren().add(imageView);
            }

 */
            if(!warrior.isAlive()){
                warrior.setImageView(null);
                warriorsInTheMap.remove(warrior);
                warriorsInTheMap.remove(warrior);
            }

        }

        simpleGame();
        round++;

    }

    public void simpleGame() {
        for (Warrior warrior : warriorsInTheMap) {
            if (warrior instanceof Troop) {
                if ((((Troop) warrior).getSpeed() == 2 && round % 12 == 0) ||
                        (((Troop) warrior).getSpeed() == 3 && round % 8 == 0) ||
                        (((Troop) warrior).getSpeed() == 4 && round % 6 == 0)) {

                    if (warrior.getArrayX() != 3) {
                        if (warrior.getArrayX() < 3) {
                            warrior.setArrayX(warrior.getArrayX() + 1);
                            moveAWarrior(warrior);
                        } else if (warrior.getArrayX() > 3) {
                            warrior.setArrayX(warrior.getArrayX() - 1);
                            moveAWarrior(warrior);
                        }



                    }
                }
            }
        }
    }

    public void moveAWarrior(Warrior warrior){
//        PathTransition slide = new PathTransition();
//        slide.setDuration(Duration.millis((3000 / ((Troop) warrior).getSpeed())));
//        slide.setNode(warrior.getImageView());
//        Line line = new Line();
//        line.setEndX(warrior.getImageView().getX() - 17.44 );
//        line.setEndY(warrior.getImageView().getY() - 14.29);
//        line.setStartX(warrior.getImageView().getX());
//        line.setStartY(warrior.getImageView().getY());
//        slide.setPath(line);
//        System.out.println(warrior.getImageView().getX() + " " + warrior.getImageView().getY());
//        System.out.println(warrior.getArrayX() + " " + warrior.getArrayY());
//        slide.play();
        warrior.getImageView().setX(warrior.getArrayX() * 17.44 + 17.44);
        warrior.getImageView().setY(warrior.getArrayY() * 14.29 + 220);
    }

    public void select(ActionEvent event) {
        Button selected = (Button) event.getSource();
        if (selected == card0 && elixir >= availableCards.get(0).getCost()) selectedCardIndex = 0;
        if (selected == card1 && elixir >= availableCards.get(1).getCost()) selectedCardIndex = 1;
        if (selected == card2 && elixir >= availableCards.get(2).getCost()) selectedCardIndex = 2;
        if (selected == card3 && elixir >= availableCards.get(3).getCost()) selectedCardIndex = 3;
    }

    public void click(double x, double y) {
        if (selectedCardIndex == -1) return;
        if (243 <= x && x <= 557 && 240 <= y && y <= 440) {
            Card card = availableCards.get(selectedCardIndex);
            int X = (int) ((x - 243) / 17.44);
            int Y = (int) ((y - 240) / 14.29);
            Warrior warrior = card.getWarrior(user, X, Y);
            map[X][Y + 14] = warrior;
            warriorsInTheMap.add(warrior);
            warrior.buildImageView();
            middlePane.getChildren().add(warrior.imageView);
            System.out.println(map[X][Y + 14].getClass().getName() + " at (" + X + "," + (Y + 14) + ")");
            setNextCard(selectedCardIndex);
            elixir -= card.getCost();
            selectedCardIndex = -1;
            playAudio("poukh");
        }
        if (map2IsValid && 243 <= x && x < 400 && 143 <= y && y <= 200) {
            Card card = availableCards.get(selectedCardIndex);
            int X = (int) ((x - 243) / 17.44);
            int Y = (int) ((y - 143) / 14.29);
            Warrior warrior = card.getWarrior(user, X, Y);
            map[X][Y + 10] = warrior;
            warriorsInTheMap.add(warrior);
            warrior.buildImageView();
            middlePane.getChildren().add(warrior.imageView);
            System.out.println(map[X][Y + 10].getClass().getName() + " at (" + X + "," + (Y + 10) + ")");
            setNextCard(selectedCardIndex);
            elixir -= card.getCost();
            selectedCardIndex = -1;
            playAudio("poukh");
        }
        if (map3IsValid && 400 <= x && x <= 557 && 143 <= y && y <= 200) {
            Card card = availableCards.get(selectedCardIndex);
            int X = (int) ((x - 400) / 17.44);
            int Y = (int) ((y - 143) / 14.29);
            Warrior warrior = card.getWarrior(user, X, Y);
            map[X + 9][Y + 10] = warrior;
            warriorsInTheMap.add(warrior);
            warrior.buildImageView();
            middlePane.getChildren().add(warrior.imageView);
            System.out.println(map[X + 9][Y + 10].getClass().getName() + " at (" + (X + 9) + "," + (Y + 10) + ")");
            setNextCard(selectedCardIndex);
            elixir -= card.getCost();
            selectedCardIndex = -1;
            playAudio("poukh");
        }
    }

    private void setNextCard(int index) {
        availableCards.set(index, nextCard);
        nextCard = getNextCard();
    }

    private Card getNextCard() {
        Card card = user.getRandomCard();
        while (availableCards.contains(card)) {
            card = user.getRandomCard();
        }
        return card;
    }

    private void playAudio(String audio){
        if(audio.equals("poukh")){
            //AudioClip audioClip=new AudioClip(getClass().getResource("audios/Poukh.m4a").toString());
            //AudioClip audioClip=new AudioClip("audios/Poukh.m4a");
            //audioClip.play();
        }
    }
}
