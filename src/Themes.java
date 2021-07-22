import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The themes scene controller.
 */
public class Themes {
    /**
     * Back.
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

    /**
     * Default theme.
     */
    public void defaultTheme() {
        Main.setTheme(Theme.DEFAULT);
    }

    /**
     * Bone theme.
     */
    public void boneTheme() {
        Main.setTheme(Theme.BONE);
    }

    /**
     * Barbarian theme.
     */
    public void barbarianTheme() {
        Main.setTheme(Theme.BARBARIAN);
    }

    /**
     * Ice theme.
     */
    public void iceTheme() {
        Main.setTheme(Theme.ICE);
    }

    /**
     * Goblin theme.
     */
    public void goblinTheme() {
        Main.setTheme(Theme.GOBLIN);
    }

    /**
     * Builder theme.
     */
    public void builderTheme() {
        Main.setTheme(Theme.BUILDER);
    }

    /**
     * Jungle theme.
     */
    public void jungleTheme() {
        Main.setTheme(Theme.JUNGLE);
    }

    /**
     * Spell theme.
     */
    public void spellTheme() {
        Main.setTheme(Theme.SPELL);
    }

    /**
     * Dark theme.
     */
    public void darkTheme() {
        Main.setTheme(Theme.DARK);
    }

    /**
     * Champion theme.
     */
    public void championTheme() {
        Main.setTheme(Theme.CHAMPION);
    }
}
