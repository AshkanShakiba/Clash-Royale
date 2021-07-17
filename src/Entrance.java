import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Entrance {
    @FXML
    ImageView imageView;

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

    public void about(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
            Parent root = loader.load();
            Game game = loader.getController();
            User user=new User();
            game.construct(user);

            Timeline updateTimeLine = new Timeline(
                    new KeyFrame(Duration.millis(250),
                            new EventHandler<ActionEvent>() {

                                @Override
                                public void handle(ActionEvent event) {
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
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void exit(ActionEvent event) {
        Main.exit((Stage) ((Node) event.getSource()).getScene().getWindow());
    }
}
