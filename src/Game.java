import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

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

    private Bot bot;
    private User user;
    private Stage stage;
    private double x, y;
    private double elixir;
    private Warrior[][] map;
    private boolean map2IsValid;
    private boolean map3IsValid;
    private Card nextCard;
    private int selectedCardIndex;
    private ArrayList<Card> availableCards;
    private HashSet<Warrior> warriorsInTheMap = new HashSet<>();
    private HashMap<Warrior, Integer> teamsMap = new HashMap<>(); // team = 0 -> down team = 1 -> up

    private double round = 0;

    public void construct(User user,Stage stage) {
        this.stage=stage;
        bot=new Bot(this);
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
    }

    public void update() {
        card0.setStyle("-fx-background-image: url('" + availableCards.get(0).getImage() + "');");
        card1.setStyle("-fx-background-image: url('" + availableCards.get(1).getImage() + "');");
        card2.setStyle("-fx-background-image: url('" + availableCards.get(2).getImage() + "');");
        card3.setStyle("-fx-background-image: url('" + availableCards.get(3).getImage() + "');");
        next.setStyle("-fx-background-image: url('" + nextCard.getImage() + "');");

        if (elixir < 10) elixir += 0.125;
        elixirBar.setProgress(((int) elixir) / 10.0);

        bot.increaseElixir();

        Iterator iterator = warriorsInTheMap.iterator();
        while (iterator.hasNext()) {
            Warrior warrior = (Warrior) iterator.next();
            if (!warrior.isAlive) {
                iterator.remove();
                middlePane.getChildren().remove(warrior.getImageView());
            }
        }


        starterWarriorsMovement();
        game();
        round = round + 0.125;

    }

    public void starterWarriorsMovement() {
        for (Warrior warrior : warriorsInTheMap) {
            if (warrior instanceof Troop) {
                if ((round % (3.0 / ((Troop) warrior).getSpeed()) == 0 )) {

                    if(Math.abs(warrior.getArrayX() - 14) > Math.abs(warrior.arrayX) - 3) {

                        if (warrior.getArrayX() != 3) {
                            if (warrior.getArrayX() < 3) {
                                warrior.setArrayX(warrior.getArrayX() + 1);
                                if(checkValidMove(warrior, warrior.getArrayX(), warrior.getArrayY())) {
                                    moveAWarrior(warrior);
                                }else{
                                    warrior.setArrayX(warrior.getArrayX() - 1);

                                }


                            } else if (warrior.getArrayX() > 3) {
                                warrior.setArrayX(warrior.getArrayX() - 1);
                                if(checkValidMove(warrior, warrior.getArrayX(), warrior.getArrayY())) {
                                    moveAWarrior(warrior);
                                }else{
                                    warrior.setArrayX(warrior.getArrayX() + 1);

                                }

                            }

                        }
                    } else {
                        if (warrior.getArrayX() != 14) {
                            if (warrior.getArrayX() < 14) {
                                warrior.setArrayX(warrior.getArrayX() + 1);
                                if(checkValidMove(warrior, warrior.getArrayX(), warrior.getArrayY())) {
                                    moveAWarrior(warrior);
                                }else{
                                    warrior.setArrayX(warrior.getArrayX() - 1);

                                }

                            } else if (warrior.getArrayX() > 14) {
                                warrior.setArrayX(warrior.getArrayX() - 1);
                                if(checkValidMove(warrior, warrior.getArrayX(), warrior.getArrayY())) {
                                    moveAWarrior(warrior);
                                }else{
                                    warrior.setArrayX(warrior.getArrayX() + 1);

                                }

                            }
                        }
                    }


                }
            }
        }
    }

    public ArrayList<Warrior> checkNearWarriors(Warrior warrior){

        ArrayList<Warrior> nearWarriors = new ArrayList<>();

        if(warrior instanceof  Troop ){
            for(Warrior wrr : warriorsInTheMap) {
                if (Math.abs(warrior.getArrayX() - wrr.getArrayX()) <= (((Troop) warrior).getRange()) + 1){
                    if (Math.abs(warrior.getArrayY() - wrr.getArrayY()) <= ((Troop) warrior).getRange() + 1){
                        if(!wrr.equals(warrior)) {
                            if(wrr instanceof RealWarriors){
                                nearWarriors.add(wrr);
                            }
                        }
                    }
                }
            }
        }

        return nearWarriors;
    }

    public boolean checkValidMove(Warrior selfWarrior, int x, int y) {
        for (Warrior warrior : warriorsInTheMap) {
            if(warrior.getArrayX() == x && warrior.getArrayY() == y && !(warrior.equals(selfWarrior))){
                return false;
            }
        }
        return true;
    }

    public void game(){
        if(round>=180){
            endGame();
        }
        if(round%1.0==0) bot.move();
        for(Warrior warrior : warriorsInTheMap){
            if((warrior.getArrayX() == 3) || (warrior.getArrayX() == 14)){

                ArrayList<Warrior> nearWarriors = checkNearWarriors(warrior);
                if(nearWarriors.size() == 0 ) {
                    if(teamsMap.get(warrior) == 0) {
                        if(warrior.getArrayY() != - 10) {
                            if (warrior instanceof Troop && (round % (3.0 / ((Troop) warrior).getSpeed()) == 0)) {
                                warrior.setArrayY(warrior.getArrayY() - 1);
                                if (checkValidMove(warrior, warrior.getArrayX(), warrior.getArrayY())) {
                                    moveAWarrior(warrior);
                                } else {
                                    warrior.setArrayY(warrior.getArrayY() + 1);
                                }
                            }
                        }
                    }else{
                        if(warrior.getArrayY() !=  5) {
                            if (warrior instanceof Troop && (round % (3.0 / ((Troop) warrior).getSpeed()) == 0)) {
                                warrior.setArrayY(warrior.getArrayY() + 1);
                                if (checkValidMove(warrior, warrior.getArrayX(), warrior.getArrayY())) {
                                    moveAWarrior(warrior);
                                } else {
                                    warrior.setArrayY(warrior.getArrayY() - 1);
                                }
                            }
                        }
                    }
                }else {
                    if(warrior instanceof RealWarriors ) {
                        if(((int)(round*1000) % (int)((((RealWarriors) warrior).getHitSpeed())*1000)) == 0) {
                            System.out.print(warrior.toString());
                            for (Warrior x : nearWarriors) {
                                System.out.print("-- " + x.toString());
                            }

                            for (Warrior nearWarrior : nearWarriors) {
                                if (nearWarrior instanceof RealWarriors) {
                                    if (warrior instanceof Troop) {
                                        ((RealWarriors) nearWarrior).damage
                                                (((Troop) warrior).getDamage() * ((Troop) warrior).getCount());
                                    } else {
                                        ((RealWarriors) nearWarrior).damage
                                                (((RealWarriors) warrior).getDamage());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void moveAWarrior(Warrior warrior) {
        System.out.println( warrior.toString() + " " + warrior.getArrayX() + " " + warrior.getArrayY());
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
            teamsMap.put(warrior, 0);
            map[X][Y + 14] = warrior;
            warriorsInTheMap.add(warrior);
            warrior.buildImageView("blue");
            middlePane.getChildren().add(warrior.imageView);
            System.out.println(map[X][Y + 14].getClass().getName() + " at (" + X + "," + (Y) + ")");
            setNextCard(selectedCardIndex);
            elixir -= card.getCost();
            selectedCardIndex = -1;
            playAudio(card.getAudio());
        }
        if (map2IsValid && 243 <= x && x < 400 && 143 <= y && y <= 200) {
            Card card = availableCards.get(selectedCardIndex);
            int X = (int) ((x - 243) / 17.44);
            int Y = (int) ((y - 143) / 14.29);
            Warrior warrior = card.getWarrior(user, X, Y);
            teamsMap.put(warrior, 0);
            map[X][Y + 10] = warrior;
            warriorsInTheMap.add(warrior);
            warrior.buildImageView("blue");
            middlePane.getChildren().add(warrior.imageView);
            System.out.println(map[X][Y + 10].getClass().getName() + " at (" + X + "," + (Y + 10) + ")");
            setNextCard(selectedCardIndex);
            elixir -= card.getCost();
            selectedCardIndex = -1;
            playAudio(card.getAudio());
        }
        if (map3IsValid && 400 <= x && x <= 557 && 143 <= y && y <= 200) {
            Card card = availableCards.get(selectedCardIndex);
            int X = (int) ((x - 400) / 17.44);
            int Y = (int) ((y - 143) / 14.29);
            Warrior warrior = card.getWarrior(user, X, Y);
            teamsMap.put(warrior, 0);
            map[X + 9][Y + 10] = warrior;
            warriorsInTheMap.add(warrior);
            warrior.buildImageView("blue");
            middlePane.getChildren().add(warrior.imageView);
            System.out.println(map[X + 9][Y + 10].getClass().getName() + " at (" + (X + 9) + "," + (Y + 10) + ")");
            setNextCard(selectedCardIndex);
            elixir -= card.getCost();
            selectedCardIndex = -1;
            playAudio(card.getAudio());
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

    public static void playAudio(String audioPath) {
        //AudioClip audioClip=new AudioClip(getClass().getResource(audioPath).toString());
        //audioClip.play();
        Media m = new Media(Paths.get("src//"+audioPath).toUri().toString());
        new MediaPlayer(m).play();
    }

    public HashMap<Warrior, Integer> getTeamsMap() {
        return teamsMap;
    }

    public Warrior[][] getMap() {
        return map;
    }

    public HashSet<Warrior> getWarriorsInTheMap() {
        return warriorsInTheMap;
    }

    public AnchorPane getMiddlePane() {
        return middlePane;
    }

    private void endGame(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("endGame.fxml"));
            Parent root = loader.load();
            EndGame endGame = loader.getController();
            //stage.initStyle(StageStyle.DECORATED);
            endGame.setScores(0,3);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public ArrayList<Warrior> getPlayerWarriors(){
        ArrayList<Warrior> warriors=new ArrayList<>();
        for(Warrior warrior:teamsMap.keySet()){
            if(teamsMap.get(warrior)==0)
                warriors.add(warrior);
        }
        return warriors;
    }
}