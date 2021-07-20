import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Menu {
    @FXML
    private PasswordField cheatField;

    public void battle(ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
            Parent root = loader.load();
            Game game = loader.getController();
            User user = new User();
            game.construct(user,stage);

            Timeline updateTimeLine = new Timeline(
                    new KeyFrame(Duration.millis(250),
                            new EventHandler<javafx.event.ActionEvent>() {

                                @Override
                                public void handle(javafx.event.ActionEvent event) {
                                    game.update();
                                    //System.out.println("this is called every 5 seconds on UI thread");
                                }
                            }));

            updateTimeLine.setCycleCount(Timeline.INDEFINITE);
            updateTimeLine.play();

            root.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    game.click(event.getSceneX(), event.getSceneY());
                }
            });

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void battleDeck(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("battleDeck.fxml"));
            Parent root = loader.load();
            BattleDeck battleDeck = loader.getController();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //stage.initStyle(StageStyle.DECORATED);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void check(ActionEvent event){
        String cheatCode=cheatField.getText();
        if(cheatCode.equalsIgnoreCase("theme")){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("themes.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                //stage.initStyle(StageStyle.DECORATED);
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        if(cheatCode.equalsIgnoreCase("royalGiant")){

        }
    }
}
