import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

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
    private Button card1;
    @FXML
    private Button card2;
    @FXML
    private Button card3;
    @FXML
    private Button card4;
    @FXML
    private Button next;

    private User user;
    private double x, y;
    private Card nextCard;
    private Card selectedCard;
    private ArrayList<Card> availableCards;

    public void construct(User user) {
        this.user = user;
    }

    public void select(ActionEvent event) {
        Button selected = (Button) event.getSource();
        selected.setStyle(selected.getStyle() + "-fx-background-image: url('assets/giant.png');");
    }

    public void click(double x, double y) {
        this.x = x;
        this.y = y;
    }

    private void setNextCard() {
        Card card = user.getRandomCard();
        while (availableCards.contains(card)) {
            card = user.getRandomCard();
        }
        nextCard = card;
    }
}
