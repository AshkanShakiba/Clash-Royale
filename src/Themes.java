import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Themes {
    public void back(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
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

    public void defaultTheme() {
        Main.setTheme(Theme.DEFAULT);
    }

    public void boneTheme() {
        Main.setTheme(Theme.BONE);
    }

    public void barbarianTheme() {
        Main.setTheme(Theme.BARBARIAN);
    }

    public void iceTheme() {
        Main.setTheme(Theme.ICE);
    }

    public void goblinTheme() {
        Main.setTheme(Theme.GOBLIN);
    }

    public void builderTheme() {
        Main.setTheme(Theme.BUILDER);
    }

    public void jungleTheme() {
        Main.setTheme(Theme.JUNGLE);
    }

    public void spellTheme() {
        Main.setTheme(Theme.SPELL);
    }

    public void darkTheme() {
        Main.setTheme(Theme.DARK);
    }

    public void championTheme() {
        Main.setTheme(Theme.CHAMPION);
    }
}
