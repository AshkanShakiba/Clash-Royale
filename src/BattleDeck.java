import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;


/**
 * The battle deck scene controller.
 */
public class BattleDeck implements Initializable {

    @FXML
    private Button deckCard8;

    @FXML
    private Button deckCard2;

    @FXML
    private Button deckCard3;

    @FXML
    private Button deckCard4;

    @FXML
    private Button deckCard6;

    @FXML
    private Button deckCard7;

    @FXML
    private Button deckCard5;

    @FXML
    private Button deckCard1;

    @FXML
    private Button storeCard10;

    @FXML
    private Button storeCard3;

    @FXML
    private Button storeCard5;

    @FXML
    private Button storeCard4;

    @FXML
    private Button storeCard9;

    @FXML
    private Button storeCard11;

    @FXML
    private Button storeCard7;

    @FXML
    private Button storeCard1;

    @FXML
    private Button storeCard2;

    @FXML
    private Button storeCard8;

    @FXML
    private Button storeCard6;

    @FXML
    private Button storeCard12;
    @FXML
    private Button saveButton;
    @FXML
    private Label statementLabel;

    private User user = new User();
    private int storeSelectedCardIndex = -1;
    private int deckSelectedCardIndex = -1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        storeCard1.setStyle("-fx-background-image: url('" + user.getCards().get(0).getImage() + "');");
        storeCard2.setStyle("-fx-background-image: url('" + user.getCards().get(1).getImage() + "');");
        storeCard3.setStyle("-fx-background-image: url('" + user.getCards().get(2).getImage() + "');");
        storeCard4.setStyle("-fx-background-image: url('" + user.getCards().get(3).getImage() + "');");
        storeCard5.setStyle("-fx-background-image: url('" + user.getCards().get(4).getImage() + "');");
        storeCard6.setStyle("-fx-background-image: url('" + user.getCards().get(5).getImage() + "');");
        storeCard7.setStyle("-fx-background-image: url('" + user.getCards().get(6).getImage() + "');");
        storeCard8.setStyle("-fx-background-image: url('" + user.getCards().get(7).getImage() + "');");
        storeCard9.setStyle("-fx-background-image: url('" + user.getCards().get(8).getImage() + "');");
        storeCard10.setStyle("-fx-background-image: url('" + user.getCards().get(9).getImage() + "');");
        storeCard11.setStyle("-fx-background-image: url('" + user.getCards().get(10).getImage() + "');");
        storeCard12.setStyle("-fx-background-image: url('" + user.getCards().get(11).getImage() + "');");

        user = Main.getUsers().get(0);

        for (int i = 0; i < 8; i++) {
            if (user.getCurrentCards()[i] != null) {
                switch (i) {
                    case 0: {
                        deckCard1.setStyle("-fx-background-image: url('" + user.getCurrentCards()[0].getImage() + "');");
                        break;
                    }
                    case 1: {
                        deckCard2.setStyle("-fx-background-image: url('" + user.getCurrentCards()[1].getImage() + "');");
                        break;
                    }
                    case 2: {
                        deckCard3.setStyle("-fx-background-image: url('" + user.getCurrentCards()[2].getImage() + "');");
                        break;
                    }
                    case 3: {
                        deckCard4.setStyle("-fx-background-image: url('" + user.getCurrentCards()[3].getImage() + "');");
                        break;
                    }
                    case 4: {
                        deckCard5.setStyle("-fx-background-image: url('" + user.getCurrentCards()[4].getImage() + "');");
                        break;
                    }
                    case 5: {
                        deckCard6.setStyle("-fx-background-image: url('" + user.getCurrentCards()[5].getImage() + "');");
                        break;
                    }
                    case 6: {
                        deckCard7.setStyle("-fx-background-image: url('" + user.getCurrentCards()[6].getImage() + "');");
                        break;
                    }
                    case 7: {
                        deckCard8.setStyle("-fx-background-image: url('" + user.getCurrentCards()[7].getImage() + "');");
                        break;
                    }
                }

            }
        }


    }

    /**
     * Save button on action.
     */
    public void saveButtonOnAction() {
        String message = "";
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        for (int i = 0; i < 8; i++) {
            Card currentCard = user.getCurrentCards()[i];
            System.out.print(currentCard + " ");
            if (currentCard != null) {
                message = "UPDATE userdata SET Card" + (i + 1)
                        + " = '" + currentCard.toString() + "' WHERE username = '" + user.getUsername() + "'";
                try {
                    Statement statement = connectDB.createStatement();
                    statement.executeUpdate(message);
                    statementLabel.setText("Successfully Saved the Battle Deck!");

                } catch (Exception e) {
                    statementLabel.setText("an Error Occurred during saving Battle Deck");
                    e.printStackTrace();
                    e.getCause();
                }
            }
        }


    }

    /**
     * Store select.
     *
     * @param event the event
     */
    public void storeSelect(ActionEvent event) {
        Button selected = (Button) event.getSource();
        if (selected == storeCard1) storeSelectedCardIndex = 0;
        if (selected == storeCard2) storeSelectedCardIndex = 1;
        if (selected == storeCard3) storeSelectedCardIndex = 2;
        if (selected == storeCard4) storeSelectedCardIndex = 3;
        if (selected == storeCard5) storeSelectedCardIndex = 4;
        if (selected == storeCard6) storeSelectedCardIndex = 5;
        if (selected == storeCard7) storeSelectedCardIndex = 6;
        if (selected == storeCard8) storeSelectedCardIndex = 7;
        if (selected == storeCard9) storeSelectedCardIndex = 8;
        if (selected == storeCard10) storeSelectedCardIndex = 9;
        if (selected == storeCard11) storeSelectedCardIndex = 10;
        if (selected == storeCard12) storeSelectedCardIndex = 11;
        addCheck();
    }

    /**
     * Deck select.
     *
     * @param event the event
     */
    public void deckSelect(ActionEvent event) {
        Button selected = (Button) event.getSource();
        if (selected == deckCard1) deckSelectedCardIndex = 0;
        if (selected == deckCard2) deckSelectedCardIndex = 1;
        if (selected == deckCard3) deckSelectedCardIndex = 2;
        if (selected == deckCard4) deckSelectedCardIndex = 3;
        if (selected == deckCard5) deckSelectedCardIndex = 4;
        if (selected == deckCard6) deckSelectedCardIndex = 5;
        if (selected == deckCard7) deckSelectedCardIndex = 6;
        if (selected == deckCard8) deckSelectedCardIndex = 7;
        addCheck();
    }

    /**
     * Add check.
     */
    public void addCheck() {
        if (deckSelectedCardIndex != -1 && storeSelectedCardIndex != -1) {

            Card currentCard = user.getCards().get(storeSelectedCardIndex);

            if (checkDuplicateCards(user.getCurrentCards(), currentCard)) {
                user.getCurrentCards()[deckSelectedCardIndex] = currentCard;
                statementLabel.setText("");
            } else {
                statementLabel.setText("You have already picked this card");
                return;
            }

            switch (deckSelectedCardIndex) {
                case 0: {
                    deckCard1.setStyle("-fx-background-image: " + "url('" + currentCard.getImage() + "');");
                    break;
                }
                case 1: {
                    deckCard2.setStyle("-fx-background-image: " + "url('" + currentCard.getImage() + "');");
                    break;
                }
                case 2: {
                    deckCard3.setStyle("-fx-background-image: " + "url('" + currentCard.getImage() + "');");
                    break;
                }
                case 3: {
                    deckCard4.setStyle("-fx-background-image: " + "url('" + currentCard.getImage() + "');");
                    break;
                }
                case 4: {
                    deckCard5.setStyle("-fx-background-image: " + "url('" + currentCard.getImage() + "');");
                    break;
                }
                case 5: {
                    deckCard6.setStyle("-fx-background-image: " + "url('" + currentCard.getImage() + "');");
                    break;
                }
                case 6: {
                    deckCard7.setStyle("-fx-background-image: " + "url('" + currentCard.getImage() + "');");
                    break;
                }
                case 7: {
                    deckCard8.setStyle("-fx-background-image: " + "url('" + currentCard.getImage() + "');");
                    break;
                }
            }
            /*
            if(deckSelectedCardIndex <= user.getCurrentCards().size() - 1) {
                user.getCurrentCards().remove(deckSelectedCardIndex);
                user.getCurrentCards().add(deckSelectedCardIndex, currentCard);
            }else{
                user.getCurrentCards().add(currentCard);
            }
             */
            printCards();
            deckSelectedCardIndex = -1;
            storeSelectedCardIndex = -1;
        }
    }

    /**
     * Check duplicate cards boolean.
     *
     * @param cards      the cards
     * @param targetCard the target card
     * @return the boolean
     */
    public boolean checkDuplicateCards(Card[] cards, Card targetCard) {
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != null) {
                if (cards[i].toString().equalsIgnoreCase(targetCard.toString())) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Print cards.
     */
    public void printCards() {
        for (Card card : user.getCurrentCards()) {
            if (card != null) {
                System.out.print(card.toString() + " ");
            }
        }
        System.out.println();
    }

    /**
     * Back to menu.
     *
     * @param event the event
     */
    public void back(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}