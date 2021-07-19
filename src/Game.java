import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;
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

    private double round = 0;

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
    }

    public void update() {
        card0.setStyle("-fx-background-image: url('" + availableCards.get(0).getImage() + "');");
        card1.setStyle("-fx-background-image: url('" + availableCards.get(1).getImage() + "');");
        card2.setStyle("-fx-background-image: url('" + availableCards.get(2).getImage() + "');");
        card3.setStyle("-fx-background-image: url('" + availableCards.get(3).getImage() + "');");
        next.setStyle("-fx-background-image: url('" + nextCard.getImage() + "');");

        if (elixir < 10) elixir += 5; // .125
        elixirBar.setProgress(((int) elixir) / 10.0);

        for (Warrior warrior : warriorsInTheMap) {
            if (!warrior.isAlive()) {
                warrior.setImageView(null);
                warriorsInTheMap.remove(warrior);
                warriorsInTheMap.remove(warrior);
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
            for(int i = 0; i <= ((Troop) warrior).getRange() ; i++ ){
                for(Warrior wrr : warriorsInTheMap){
                    if(wrr.getArrayX() == warrior.getArrayX() + i + 1){
                        if(wrr.getArrayY() == warrior.getArrayY() + i + 1 ||
                            warrior.getArrayY() == warrior.getArrayY() - i - 1){
                            nearWarriors.add(wrr);
                        }
                    }
                    else if(wrr.getArrayX() == warrior.getArrayX() - i - 1){
                        if(wrr.getArrayY() == warrior.getArrayY() + i + 1 ||
                                warrior.getArrayY() == warrior.getArrayY() - i - 1){
                            nearWarriors.add(wrr);
                        }
                    }else if(wrr.getArrayX() == warrior.getArrayX()){
                        if(wrr.getArrayY() == warrior.getArrayY() + i + 1 ||
                                warrior.getArrayY() == warrior.getArrayY() - i - 1){
                            nearWarriors.add(wrr);
                        }
                    }else if(wrr.getArrayY() == warrior.getArrayY()){
                        if(wrr.getArrayX() == warrior.getArrayX() + i + 1 ||
                                warrior.getArrayX() == warrior.getArrayX() - i - 1){
                            nearWarriors.add(wrr);
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


    public  void game(){
        for(Warrior warrior : warriorsInTheMap){
            if((warrior.getArrayX() == 3) || (warrior.getArrayX() == 14)){

                ArrayList<Warrior> nearWarriors = checkNearWarriors(warrior);
                if(warrior.getArrayY() != -10 ){
                    if(nearWarriors.size() == 0 ) {
                        if(warrior instanceof Troop && (round % (3.0 / ((Troop) warrior).getSpeed()) == 0)) {
                            warrior.setArrayY(warrior.getArrayY() - 1);
                            if(checkValidMove(warrior, warrior.getArrayX(), warrior.getArrayY())) {
                                moveAWarrior(warrior);
                            }else{
                                warrior.setArrayY(warrior.getArrayY() + 1);

                            } }
                    }else {
                        if(warrior instanceof RealWarriors && (round %((RealWarriors) warrior).getHitSpeed()) == 0) {
                            for (Warrior nearWarrior : warriorsInTheMap) {
                                if (nearWarrior instanceof RealWarriors) {
                                    System.out.println(000000);
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
            map[X][Y + 14] = warrior;
            warriorsInTheMap.add(warrior);
            warrior.buildImageView();
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
            map[X][Y + 10] = warrior;
            warriorsInTheMap.add(warrior);
            warrior.buildImageView();
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
            map[X + 9][Y + 10] = warrior;
            warriorsInTheMap.add(warrior);
            warrior.buildImageView();
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

    private void playAudio(String audioPath) {
        //AudioClip audioClip=new AudioClip(getClass().getResource(audioPath).toString());
        //audioClip.play();
        Media m = new Media(Paths.get("src//"+audioPath).toUri().toString());
        new MediaPlayer(m).play();
    }

    /*
    public void movingTroopsHorizontalInTheMap(int round){
        for(Warrior warrior : warriorsInTheMap){
            if(warrior instanceof Troop) {
                if ((((Troop) warrior).getSpeed() == 2 && round % 12 == 0) ||
                        (((Troop) warrior).getSpeed() == 3 && round % 8 == 0) ||
                        (((Troop) warrior).getSpeed() == 4 && round % 6 == 0)) {
                    if (warrior.getArrayX() != 4) {
                        if (warrior.getArrayX() < 4) {
                            warrior.setArrayX(warrior.getArrayX() + 1);
                        } else if (warrior.getArrayX() > 4) {
                            warrior.setArrayX(warrior.getArrayX() - 1);
                        }

                        PathTransition slide = new PathTransition();
                        slide.setDuration(Duration.millis((3000 / ((Troop) warrior).getSpeed())));
                        slide.setNode(warrior.getImageView());
                        Line line = new Line();
                        line.setStartX(warrior.getImageView().getX());
                        line.setStartY(warrior.getImageView().getY());
                        line.setEndX(warrior.getArrayX() * 17.44 + 25);
                        line.setEndY(warrior.getImageView().getY());
                        slide.setPath(line);
                        System.out.println(warrior.getImageView().getX() + " " + warrior.getImageView().getY());
                        System.out.println(warrior.getArrayX() + " " + warrior.getArrayY());
                        slide.play();
                        warrior.getImageView().setX(warrior.getArrayX() * 17.44 + 25);
                    } else {
                        System.out.println("********************************");
                        movingTroopsVerticalInTheMap(round);
                    }
                }
            }
        }
    }


    public void movingTroopsVerticalInTheMap(int round){

        for(Warrior warrior : warriorsInTheMap){
            if(warrior instanceof Troop) {
               if ((((Troop) warrior).getSpeed() == 2 && round % 12 == 0) ||
                        (((Troop) warrior).getSpeed() == 3 && round % 8 == 0) ||
                       (((Troop) warrior).getSpeed() == 4 && round % 6 == 0)) {
                    if (warrior.getArrayY() != 0) {
                        if (warrior.getArrayY() < 0) {
                            warrior.setArrayY(warrior.getArrayY() + 1);
                        } else if (warrior.getArrayY() > 0) {
                            warrior.setArrayY(warrior.getArrayY() - 1);
                        }

                        PathTransition slide = new PathTransition();
                        slide.setDuration(Duration.millis((3000 / ((Troop) warrior).getSpeed())));
                        slide.setNode(warrior.getImageView());
                        Line line = new Line();
                        line.setStartX(warrior.getImageView().getX());
                        line.setStartY(warrior.getImageView().getY());
                        line.setEndX(warrior.getImageView().getX());
                        line.setEndY(warrior.getArrayY() * 14.29 + 240 - 10);
                        slide.setPath(line);
                        System.out.println(warrior.getImageView().getX() + " " + warrior.getImageView().getY());
                        System.out.println(warrior.getArrayX() + " " + warrior.getArrayY());
                        slide.play();
                        warrior.getImageView().setY(warrior.getArrayY() * 14.29 + 240 - 10);
                    }
                }
            }
        }

 */
}
