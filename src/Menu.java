import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Menu.
 */
public class Menu {
    @FXML
    private PasswordField cheatField;
    @FXML
    private Label battleDeckLabel;

    /**
     * Battle.
     *
     * @param event the event
     */
    public void battle(ActionEvent event) {
        boolean goNext = true;
        for (int i = 0; i < 8; i++) {
            if (Main.getUsers().get(0).getCurrentCards()[i] == null) {
                goNext = false;
                battleDeckLabel.setText("Please select 8 cards in battle deck first");
            }
        }
        if (goNext) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("botLevel.fxml"));
                Parent root = loader.load();
                BotLevel botLevel = loader.getController();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    /**
     * Battle deck.
     *
     * @param event the event
     */
    public void battleDeck(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("battleDeck.fxml"));
            Parent root = loader.load();
            BattleDeck battleDeck = loader.getController();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * History.
     *
     * @param event the event
     */
    public void history(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("battleHistory.fxml"));
            Parent root = loader.load();
            BattleHistory battleHistory = loader.getController();
            battleHistory.setUser(Main.getUsers().get(0));
            battleHistory.show();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Check.
     *
     * @param event the event
     */
    public void check(ActionEvent event) {
        String cheatCode = cheatField.getText();
        if (cheatCode.equalsIgnoreCase("exit")) {
            Main.exit((Stage) ((Node) event.getSource()).getScene().getWindow());
        }
        if (cheatCode.equalsIgnoreCase("theme")) {
            theme(event);
        }
        if (cheatCode.equalsIgnoreCase("royalGiant")) {
            Giant.upgrade();
            System.out.println("Giant upgraded");
        }
        if (cheatCode.equalsIgnoreCase("vikiBarbarians")) {
            Barbarians.upgradeToViki();
            System.out.println("Barbarians upgraded to Viki");
        }
        if (cheatCode.equalsIgnoreCase("quickBarbarians")) {
            Barbarians.upgradeToQuick();
            System.out.println("Barbarians upgraded to Quick");
        }
        if (cheatCode.equalsIgnoreCase("xpAndLevel")) {
            Main.getUsers().get(0).setXp(500);
        }
        if (cheatCode.equalsIgnoreCase("xpAndLevelCheatCode")) {
            Main.getUsers().get(0).setXp(2000);
        }
        cheatField.setText("");
    }

    /**
     * Theme.
     *
     * @param event the event
     */
    public void theme(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("themes.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Scoreboard.
     *
     * @param event the event
     */
    public void scoreboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("leaderBoard.fxml"));
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
