import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.util.ArrayList;

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

    private User user;
    private double x, y;
    private Card nextCard;
    private Card selectedCard;
    private ArrayList<Card> availableCards;

    public void construct(User user) {
        this.user = user;
        availableCards = new ArrayList<>();
        availableCards.add(getNextCard());
        availableCards.add(getNextCard());
        availableCards.add(getNextCard());
        availableCards.add(getNextCard());
        nextCard = getNextCard();
        update();
    }

    public void update() {
        card0.setStyle("-fx-background-image: url('" + availableCards.get(0).getImage() + "');");
        card1.setStyle("-fx-background-image: url('" + availableCards.get(1).getImage() + "');");
        card2.setStyle("-fx-background-image: url('" + availableCards.get(2).getImage() + "');");
        card3.setStyle("-fx-background-image: url('" + availableCards.get(3).getImage() + "');");
        next.setStyle("-fx-background-image: url('" + nextCard.getImage() + "');");
    }

    public void select(ActionEvent event) {
        Button selected = (Button) event.getSource();
        if(selected==card0) putCard(0);
        if(selected==card1) putCard(1);
        if(selected==card2) putCard(2);
        if(selected==card3) putCard(3);
    }

    public void click(double x, double y) {
        this.x = x;
        this.y = y;
        System.out.println("(" + x + "," + y + ")");
        update();
    }

    private void putCard(int index) {
        availableCards.set(index,nextCard);
        nextCard = getNextCard();
    }

    private Card getNextCard() {
        Card card = user.getRandomCard();
        while (availableCards.contains(card)) {
            card = user.getRandomCard();
        }
        return card;
    }
}
