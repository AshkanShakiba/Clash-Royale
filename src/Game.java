import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

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

    @FXML
    private ImageView queenDownRight1;

    @FXML
    private ImageView queenDownLeft1;

    @FXML
    private ImageView kingUp1;

    @FXML
    private ImageView kingUp2;

    @FXML
    private ImageView kingDown1;

    @FXML
    private ImageView kingDown2;

    @FXML
    private ImageView queenDownRight2;

    @FXML
    private ImageView queenDownLeft2;

    @FXML
    private ImageView queenUpLeft1;

    @FXML
    private ImageView queenUpRight1;

    @FXML
    private ImageView queenUpRight2;

    @FXML
    private ImageView queenUpLeft2;

    @FXML
    private ImageView topArena;
    @FXML
    private ImageView bottomArena;
    @FXML
    private Label timer;

    @FXML
    private AnchorPane anchorPane;

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
    private HashMap<Warrior, Boolean> endOfFaze1Warrior = new HashMap<>();
    private HashMap<Warrior, Double> buildingBuiltTime = new HashMap<>();
    private HashMap<Warrior, Double> warriorsOnRage = new HashMap<>();

    private int score1 = 0;
    private int score2 = 0;

    private KingTower kingTowerUp;
    private KingTower kingTowerDown;
    private QueenTower queenTowerUpLeft;
    private QueenTower queenTowerUpRight;
    private QueenTower queenTowerDownLeft;
    private QueenTower queenTowerDownRight;

    private boolean runEndGameOnce = false;

    private double round = 0;

    public void construct(User user, Stage stage,int botLevel) {
        setTheme();

        this.stage = stage;
        bot = new Bot(this, botLevel);
        elixir = 4;
        map = new Warrior[18][28];
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 28; j++) {
                map[i][j] = null;
            }
        }
        map2IsValid = false;
        map3IsValid = false;
        this.user = user;

        availableCards = new ArrayList<>();
        availableCards.add(getNextCard());
        availableCards.add(getNextCard());
        availableCards.add(getNextCard());
        availableCards.add(getNextCard());
        nextCard = getNextCard();
        selectedCardIndex = -1;

        kingTowerUp = new KingTower(user, 9, -14);
        kingTowerDown = new KingTower(user, 9, 9);
        queenTowerDownLeft = new QueenTower(user, 3, 5);
        queenTowerDownRight = new QueenTower(user, 14, 5);
        queenTowerUpRight = new QueenTower(user, 14, -10);
        queenTowerUpLeft = new QueenTower(user, 3, -10);

        //warriorsInTheMap.add(kingTowerUp);
        //warriorsInTheMap.add(kingTowerDown);
        warriorsInTheMap.add(queenTowerDownLeft);
        warriorsInTheMap.add(queenTowerDownRight);
        warriorsInTheMap.add(queenTowerUpRight);
        warriorsInTheMap.add(queenTowerUpLeft);
        //teamsMap.put(kingTowerUp, 1);
        //teamsMap.put(kingTowerDown, 0);
        teamsMap.put(queenTowerDownLeft, 0);
        teamsMap.put(queenTowerDownRight, 0);
        teamsMap.put(queenTowerUpRight, 1);
        teamsMap.put(queenTowerUpLeft, 1);

    }

    public void update() {
        if (!endCheck()) {
            card0.setStyle("-fx-background-image: url('" + availableCards.get(0).getImage() + "');");
            card1.setStyle("-fx-background-image: url('" + availableCards.get(1).getImage() + "');");
            card2.setStyle("-fx-background-image: url('" + availableCards.get(2).getImage() + "');");
            card3.setStyle("-fx-background-image: url('" + availableCards.get(3).getImage() + "');");
            next.setStyle("-fx-background-image: url('" + nextCard.getImage() + "');");

            if (elixir < 10) {
                if (round < 60) {
                    elixir += 0.125;
                    bot.increaseElixir(0.125);
                } else {
                    elixir += 0.250;
                    bot.increaseElixir(0.250);
                }
            }
            elixirBar.setProgress(((int) elixir) / 10.0);


            Iterator iterator = warriorsInTheMap.iterator();
            while (iterator.hasNext()) {
                Warrior warrior = (Warrior) iterator.next();
                if (!warrior.isAlive) {
                    iterator.remove();
                    middlePane.getChildren().remove(warrior.getImageView());
                }
            }


            gameFaze1();
            gameFaze2();
            gameFaze3();
            checkBuildingLifeTime();
            if (round % 1 == 0) {
                bot.move();
            }
            rageManagement();
            towerManagement();
            endCheck();
            round = round + 0.125;
            setTimer();
        } else {
            if (!runEndGameOnce) {
                runEndGameOnce = true;
                endGame();
            }
        }

    }

    public void gameFaze1() {
        for (Warrior warrior : warriorsInTheMap) {
            if (endOfFaze1Warrior.get(warrior) != null && !endOfFaze1Warrior.get(warrior)) {
                if (warrior instanceof Troop) {
                    if ((round % (3.0 / ((Troop) warrior).getSpeed()) == 0)) {

                        if (Math.abs(warrior.getArrayX() - 14) > Math.abs(warrior.arrayX) - 3) {

                            if (warrior.getArrayX() != 3) {
                                if (warrior.getArrayX() < 3) {
                                    warrior.setArrayX(warrior.getArrayX() + 1);
                                    if (checkValidMove(warrior, warrior.getArrayX(), warrior.getArrayY())) {
                                        moveAWarrior(warrior);
                                    } else {
                                        warrior.setArrayX(warrior.getArrayX() - 1);

                                    }


                                } else if (warrior.getArrayX() > 3) {
                                    warrior.setArrayX(warrior.getArrayX() - 1);
                                    if (checkValidMove(warrior, warrior.getArrayX(), warrior.getArrayY())) {
                                        moveAWarrior(warrior);
                                    } else {
                                        warrior.setArrayX(warrior.getArrayX() + 1);

                                    }

                                }

                            }
                        } else {
                            if (warrior.getArrayX() != 14) {
                                if (warrior.getArrayX() < 14) {
                                    warrior.setArrayX(warrior.getArrayX() + 1);
                                    if (checkValidMove(warrior, warrior.getArrayX(), warrior.getArrayY())) {
                                        moveAWarrior(warrior);
                                    } else {
                                        warrior.setArrayX(warrior.getArrayX() - 1);

                                    }

                                } else if (warrior.getArrayX() > 14) {
                                    warrior.setArrayX(warrior.getArrayX() - 1);
                                    if (checkValidMove(warrior, warrior.getArrayX(), warrior.getArrayY())) {
                                        moveAWarrior(warrior);
                                    } else {
                                        warrior.setArrayX(warrior.getArrayX() + 1);

                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void gameFaze2() {
        for (Warrior warrior : warriorsInTheMap) {
            if ((warrior.getArrayX() == 3) || (warrior.getArrayX() == 14) || warrior instanceof Building) {
                endOfFaze1Warrior.replace(warrior, true);
                ArrayList<Warrior> nearWarriors = checkNearWarriors(warrior);
                if (nearWarriors.size() == 0) {
                    if (teamsMap.get(warrior) == 0) {
                        if (warrior.getArrayY() != -14) {
                            if (warrior instanceof Troop && (round % (3.0 / ((Troop) warrior).getSpeed()) == 0)) {
                                warrior.setArrayY(warrior.getArrayY() - 1);
                                if (checkValidMove(warrior, warrior.getArrayX(), warrior.getArrayY())) {
                                    moveAWarrior(warrior);
                                } else {
                                    warrior.setArrayY(warrior.getArrayY() + 1);
                                }
                            }
                        }
                    } else {
                        if (warrior.getArrayY() != 9) {
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
                } else {
                    damage(warrior, nearWarriors);
                }
            }
        }
    }

    public void gameFaze3() {
        for (Warrior warrior : warriorsInTheMap) {
            if (warrior instanceof Troop) {
                if ((teamsMap.get(warrior) == 0 && warrior.getArrayY() == -14)
                        || (teamsMap.get(warrior) == 1 && warrior.getArrayY() == 9)) {
                    ArrayList<Warrior> nearWarriors = checkNearWarriors(warrior);
                    if (nearWarriors.size() == 0) {
                        if ((round % (3.0 / ((Troop) warrior).getSpeed()) == 0)) {
                            if (warrior.getArrayX() != 9) {
                                if (warrior.getArrayX() < 9) {
                                    warrior.setArrayX(warrior.getArrayX() + 1);
                                    if (checkValidMove(warrior, warrior.getArrayX(), warrior.getArrayY())) {
                                        moveAWarrior(warrior);
                                    } else {
                                        warrior.setArrayX(warrior.getArrayX() - 1);

                                    }

                                } else if (warrior.getArrayX() > 9) {
                                    warrior.setArrayX(warrior.getArrayX() - 1);
                                    if (checkValidMove(warrior, warrior.getArrayX(), warrior.getArrayY())) {
                                        moveAWarrior(warrior);
                                    } else {
                                        warrior.setArrayX(warrior.getArrayX() + 1);

                                    }

                                }

                            }
                        }
                    } else {
                        damage(warrior, nearWarriors);
                    }

                }
            }
        }
    }

    private void damage(Warrior warrior, ArrayList<Warrior> nearWarriors) {
        if (warrior instanceof RealWarrior) {
            if (((int) (round * 1000) % (int) ((((RealWarrior) warrior).getHitSpeed()) * 1000)) == 0) {
                for (Warrior nearWarrior : nearWarriors) {
                    if (nearWarrior instanceof RealWarrior) {
                        System.out.println(warrior.toString() + " -- " + nearWarrior.toString());
                        ((RealWarrior) nearWarrior).damage(((RealWarrior) warrior).getDamage());

                        if (((RealWarrior) warrior).getRange() == 0
                                || warrior instanceof KingTower || warrior instanceof QueenTower) {
                            break;
                        }
                    }
                }
            }
        } else if (warrior instanceof DamagingSpells) {
            for (Warrior nearWarrior : nearWarriors) {
                if (nearWarrior instanceof RealWarrior) {
                    System.out.println(warrior.toString() + " -- " + nearWarrior.toString());
                    ((RealWarrior) nearWarrior).damage(((DamagingSpells) warrior).getAreaDamage());
                }
            }
        }
    }

    public boolean endCheck() {
        if (round >= 90 || !kingTowerDown.isAlive() || !kingTowerUp.isAlive()) {
            return true;
        }
        return false;
    }

    public ArrayList<Warrior> checkNearWarriors(Warrior warrior) {

        ArrayList<Warrior> nearWarriors = new ArrayList<>();

        for (Warrior wrr : warriorsInTheMap) {
            if (Math.abs(warrior.getArrayX() - wrr.getArrayX()) <= ((warrior).getRange()) + 1) {
                if (Math.abs(warrior.getArrayY() - wrr.getArrayY()) <= ((warrior).getRange() + 1)) {
                    if (!wrr.equals(warrior)) {
                        if (wrr instanceof RealWarrior) {
                            if(warrior instanceof RealWarrior || warrior instanceof DamagingSpells) {
                                if (!teamsMap.get(warrior).equals(teamsMap.get(wrr))) {
                                    if (warrior instanceof RealWarrior) {
                                        switch (((RealWarrior) warrior).getTarget()) {
                                            case 0: {
                                                if (((RealWarrior) wrr).getZone() == 0) {
                                                    nearWarriors.add(wrr);
                                                }
                                                break;
                                            }
                                            case 1: {
                                                if (((RealWarrior) wrr).getZone() == 1) {
                                                    nearWarriors.add(wrr);
                                                }
                                                break;
                                            }
                                            case 2: {
                                                nearWarriors.add(wrr);
                                                break;
                                            }
                                            case 3: {
                                                if (wrr instanceof Building) {
                                                    nearWarriors.add(wrr);
                                                }
                                                break;
                                            }
                                        }
                                    } else {
                                        nearWarriors.add(wrr);
                                    }
                                }
                            }else {
                                if (teamsMap.get(warrior).equals(teamsMap.get(wrr))) {
                                    nearWarriors.add(wrr);
                                }
                            }
                        }
                    }
                }
            }
        }

        if(warrior instanceof InfernoTower){
            if(nearWarriors.size() > 0){
                if(((InfernoTower) warrior).getDamage() < ((InfernoTower) warrior).getMaxDamage()) {
                    ((InfernoTower) warrior).setDamage(((InfernoTower) warrior).getDamage() + 4);
                }
            }else{
                ((InfernoTower) warrior).setDamage(((InfernoTower) warrior).getBaseDamage());
            }
            //System.out.println( nearWarriors.size() + "         " + ((InfernoTower) warrior).getDamage());
        }

//        if(warrior instanceof MiniPekka){
//            String image;
//            if ((round % (3.0 / ((Troop) warrior).getSpeed()) == 0)) {
//                if (nearWarriors.size() > 0) {
//                    image = "sprites/MiniPekkaFightBlue.gif";
//                } else {
//                    image = "sprites/MiniPekkaBlue.gif";
//                }
//                warrior.getImageView().setImage(new Image(image));
//            }
//        }


        return nearWarriors;
    }

    public void rageManagement(){
        Iterator<Warrior> it = warriorsOnRage.keySet().iterator();
        ArrayList<Warrior> toRemove = new ArrayList<>();
        while (it.hasNext()) {
            Warrior warrior = it.next();
            if (round == warriorsOnRage.get(warrior)) {
                if (warrior instanceof RealWarrior) {
                    ((RealWarrior) warrior).setDamage((int) (((RealWarrior) warrior).getDamage() * 1.4));
                    ((RealWarrior) warrior).setHitSpeed(((RealWarrior) warrior).getHitSpeed() - 0.25);

                    if (warrior instanceof Troop) {
                        ((Troop) warrior).setDamage((int) (((Troop) warrior).getDamage() * 1.4));
                    }
                }
            } else if (round - warriorsOnRage.get(warrior) > (new Rage(user, 8, 8).getDuration() / 2)) {
                ((RealWarrior) warrior).setDamage((int) (((RealWarrior) warrior).getDamage() * 0.7));
                ((RealWarrior) warrior).setHitSpeed(((RealWarrior) warrior).getHitSpeed() + 0.25);

                if (warrior instanceof Troop) {
                    ((Troop) warrior).setDamage((int) (((Troop) warrior).getDamage() * 0.7));
                }
                toRemove.add(warrior);
            }
        }

        for(Warrior warrior : toRemove){
            warriorsOnRage.remove(warrior);
        }
    }

    public boolean checkValidMove(Warrior selfWarrior, int x, int y) {
        for (Warrior warrior : warriorsInTheMap) {
            if (warrior.getArrayX() == x && warrior.getArrayY() == y && !(warrior.equals(selfWarrior))) {
                if ((!(warrior instanceof Building)) && (!(warrior instanceof Spell))) {
                    return false;
                }
            }
        }
        return true;
    }

    public void towerManagement() {
        score1 = 0;
        if (!queenTowerUpLeft.isAlive() || !queenTowerUpRight.isAlive()) {
            warriorsInTheMap.add(kingTowerUp);
            teamsMap.put(kingTowerUp, 1);
            if (!queenTowerUpLeft.isAlive()) {
                score1++;
                map2IsValid = true;
                queenUpLeft1.setImage(null);
                queenUpLeft2.setImage(null);
            } else {
                score1++;
                map3IsValid = true;
                queenUpRight1.setImage(null);
                queenUpRight2.setImage(null);
            }
        }
        score2 = 0;
        if (!queenTowerDownRight.isAlive() || !queenTowerDownLeft.isAlive()) {
            warriorsInTheMap.add(kingTowerDown);
            teamsMap.put(kingTowerDown, 0);
            if (!queenTowerDownLeft.isAlive()) {
                score2++;
                queenDownLeft1.setImage(null);
                queenDownLeft2.setImage(null);
            } else {
                score2++;
                queenDownRight1.setImage(null);
                queenDownRight2.setImage(null);
            }
        }

        if (!kingTowerUp.isAlive()) {
            score1 = 3;
            kingUp1.setImage(null);
            kingUp2.setImage(null);
        }

        if (!kingTowerDown.isAlive()) {
            score2 = 3;
            kingDown1.setImage(null);
            kingDown2.setImage(null);
        }

    }

    public void moveAWarrior(Warrior warrior) {
        System.out.println(warrior.toString() + " " + warrior.getArrayX() + " " + warrior.getArrayY());
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

        Card card = availableCards.get(selectedCardIndex);
        if (card == Card.ARROWS || card == Card.FIREBALL) {
            int X = (int) ((x - 243) / 17.44);
            int Y = (int) ((y - 240) / 14.29);
            putWarriorLogic(X, Y, 0);
            return;
        }

        if (243 <= x && x <= 557 && 240 <= y && y <= 440) {
            int X = (int) ((x - 243) / 17.44);
            int Y = (int) ((y - 240) / 14.29);
            putWarriorLogic(X, Y, 0);
        }
        if (map2IsValid && 243 <= x && x < 400 && 120 <= y && y <= 200) {
            int X = (int) ((x - 243) / 17.44);
            int Y = (int) ((y - 240) / 14.29);
            putWarriorLogic(X, Y, 0);
        }
        if (map3IsValid && 400 <= x && x <= 557 && 120 <= y && y <= 200) {
            int X = (int) ((x - 243) / 17.44);
            int Y = (int) ((y - 240) / 14.29);
            putWarriorLogic(X, Y, 0);
        }
    }

    public void putWarriorLogic(int X, int Y, int team) {
        Card card = availableCards.get(selectedCardIndex);
        Warrior warrior = card.getWarrior(user, X, Y);

        if (warrior instanceof Barbarians) {
            ArrayList<Warrior> toPut = new ArrayList<>();
            if (checkValidMove(warrior, X, Y)) {
                toPut.add(warrior);
            }
            if (checkValidMove(warrior, X + 1, Y)) {
                warrior = card.getWarrior(user, X + 1, Y);
                toPut.add(warrior);
            }
            if (checkValidMove(warrior, X, Y - 1)) {
                warrior = card.getWarrior(user, X, Y - 1);
                toPut.add(warrior);
            }
            if (checkValidMove(warrior, X + 1, Y - 1)) {
                warrior = card.getWarrior(user, X + 1, Y - 1);
                toPut.add(warrior);
            }
            if (toPut.size() == 4) {
                for (Warrior wrr : toPut) {
                    putWarriorInThePoint(wrr, wrr.getArrayX(), wrr.arrayY, team);
                }
                elixir -= card.getCost();
                playAudio(card.getAudio());
                setNextCard(selectedCardIndex);
                selectedCardIndex = -1;
            }
        } else if (warrior instanceof Archers) {
            ArrayList<Warrior> toPut = new ArrayList<>();
            if (checkValidMove(warrior, X, Y)) {
                toPut.add(warrior);
            }
            if (checkValidMove(warrior, X + 1, Y)) {
                warrior = card.getWarrior(user, X + 1, Y);
                toPut.add(warrior);
            }
            if (toPut.size() == 2) {
                for (Warrior wrr : toPut) {
                    putWarriorInThePoint(wrr, wrr.getArrayX(), wrr.arrayY, team);
                }
                elixir -= card.getCost();
                playAudio(card.getAudio());
                setNextCard(selectedCardIndex);
                selectedCardIndex = -1;
            }
        } else if (checkValidMove(warrior, X, Y)) {
            putWarriorInThePoint(warrior, X, Y, team);
            playAudio(card.getAudio());
            setNextCard(selectedCardIndex);
            selectedCardIndex = -1;
            elixir -= card.getCost();
        }
    }

    public void putWarriorInThePoint(Warrior warrior, int X, int Y, int team) {
        warriorsInTheMap.add(warrior);
        teamsMap.put(warrior, team);
        buildingBuiltTime.put(warrior, round);
        if(warrior instanceof  Rage){
            for(Warrior wrr : checkNearWarriors(warrior)){
                warriorsOnRage.put(wrr, round);
            }
        }

        endOfFaze1Warrior.put(warrior, false);
        //map[X][Y + 10] = warrior;
        if (warrior instanceof Arrows) {
            if (X < 9) {
                warrior.buildImageView("blue left");
            } else {
                warrior.buildImageView("blue right");
            }
        } else {
            warrior.buildImageView("blue");
        }
        middlePane.getChildren().add(warrior.imageView);
        System.out.println(warrior.toString() + " at (" + X + "," + (Y) + ")");

    }

    public void checkBuildingLifeTime() {
        for (Warrior warrior : warriorsInTheMap) {
            if (warrior instanceof Building) {
                if (buildingBuiltTime.get(warrior) != null &&
                        (round - buildingBuiltTime.get(warrior)) >= (((Building) warrior).getLifetime() / 2)) {
                    warrior.setAlive(false);
                }
            } else if (warrior instanceof Spell) {
                if (buildingBuiltTime.get(warrior) != null &&
                        (round - buildingBuiltTime.get(warrior)) >= (((Spell) warrior).getDuration() / 2)) {
                    warrior.setAlive(false);
                }
            }
        }
    }

    public HashMap<Warrior, Boolean> getEndOfFaze1Warrior() {
        return endOfFaze1Warrior;
    }

    public double getRound() {
        return round;
    }

    public HashMap<Warrior, Double> getBuildingBuiltTime() {
        return buildingBuiltTime;
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
        Media m = new Media(Paths.get("src//" + audioPath).toUri().toString());
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

    private void endGame() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("endGame.fxml"));
            Parent root = loader.load();
            EndGame endGame = loader.getController();
            //stage.initStyle(StageStyle.DECORATED);
            // score2: Bot, score1: Player
            endGame.setScores(score2, score1);
            endGame.setUserXp(user);
            endGame.setUserTitle(user);
            endGame.updateUserData();
            if(score2==score1){
                int botHp=kingTowerUp.getHp()+queenTowerUpLeft.getHp()+queenTowerUpRight.getHp();
                int playerHp=kingTowerDown.getHp()+queenTowerDownLeft.getHp()+queenTowerDownRight.getHp();
                endGame.setHps(botHp,playerHp);
            }
            endGame.setEmotes();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


    public ArrayList<Warrior> getPlayerWarriors() {
        ArrayList<Warrior> warriors = new ArrayList<>();
        for (Warrior warrior : teamsMap.keySet()) {
            if (teamsMap.get(warrior) == 0)
                warriors.add(warrior);
        }
        return warriors;
    }

    private void setTimer() {
        int seconds = 180 - (int) (round * 2);
        String label = seconds / 60 + ":";
        if (seconds % 60 < 10) label += "0";
        label += seconds % 60;
        timer.setText(label);
    }

    private void setTheme() {
        Theme theme = Main.getTheme();
        topArena.setImage(theme.getImage());
        bottomArena.setImage(theme.getImage());
        String url = "themes/" + theme.name() + "r.PNG";
        anchorPane.setStyle(anchorPane.getStyle() + "-fx-background-image: url('" + url + "');");
    }
}