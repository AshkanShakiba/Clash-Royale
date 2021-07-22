import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The Entrance scene controller.
 */
public class Entrance {
    /**
     * The Image view.
     */
    @FXML
    ImageView imageView;

    /**
     * Start.
     *
     * @param event the event
     */
    public void start(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signIn.fxml"));
            Parent root = loader.load();
            SignIn signIn = loader.getController();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * About.
     *
     * @param event the event
     */
    public void about(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("about.fxml"));
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
     * Exit.
     *
     * @param event the event
     */
    public void exit(ActionEvent event) {
        Main.exit((Stage) ((Node) event.getSource()).getScene().getWindow());
    }
}
