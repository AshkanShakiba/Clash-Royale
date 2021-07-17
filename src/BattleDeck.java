import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;


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

    }

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
    
    public void addCheck(){
        if(deckSelectedCardIndex != -1 && storeSelectedCardIndex != -1){

            Card currentCard = user.getCards().get(storeSelectedCardIndex);

            switch (deckSelectedCardIndex){
                case 0:{
                    deckCard1.setStyle("-fx-background-image: " + "url('" + currentCard.getImage() + "');");
                    break;
                } case 1:{
                    deckCard2.setStyle("-fx-background-image: " + "url('" + currentCard.getImage() + "');");
                    break;
                } case 2:{
                    deckCard3.setStyle("-fx-background-image: " + "url('" + currentCard.getImage() + "');");
                    break;
                } case 3:{
                    deckCard4.setStyle("-fx-background-image: " + "url('" + currentCard.getImage() + "');");
                    break;
                } case 4:{
                    deckCard5.setStyle("-fx-background-image: " + "url('" + currentCard.getImage() + "');");
                    break;
                } case 5:{
                    deckCard6.setStyle("-fx-background-image: " + "url('" + currentCard.getImage() + "');");
                    break;
                } case 6:{
                    deckCard7.setStyle("-fx-background-image: " + "url('" + currentCard.getImage() + "');");
                    break;
                } case 7:{
                    deckCard8.setStyle("-fx-background-image: " + "url('" + currentCard.getImage() + "');");
                    break;
                }
            }
            if(deckSelectedCardIndex <= user.getCurrentCards().size() - 1) {
                user.getCurrentCards().remove(deckSelectedCardIndex);
            }
            user.getCurrentCards().add(deckSelectedCardIndex, currentCard);
            printCards();
            deckSelectedCardIndex = -1;
            storeSelectedCardIndex = -1;
        }
    }

    public void printCards(){
        for(Card card : user.getCurrentCards()){
            System.out.print(card.toString() + " ");
        }
        System.out.println();
    }
}
