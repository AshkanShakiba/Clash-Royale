import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu {
    @FXML
    private PasswordField cheatField;

    public void battle(ActionEvent event) {
        System.out.println(Main.getUser().getUsername());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("botLevel.fxml"));
            Parent root = loader.load();
            BotLevel botLevel = loader.getController();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //stage.initStyle(StageStyle.DECORATED);
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

    public void check(ActionEvent event) {
        String cheatCode = cheatField.getText();
        if (cheatCode.equalsIgnoreCase("theme")) {
            theme(event);
        }
        if (cheatCode.equalsIgnoreCase("royalGiant")) {
            Giant.upgrade();
            System.out.println("Giant upgraded");
        }
    }

    public void theme(ActionEvent event) {
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
}
