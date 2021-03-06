import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * The bot level scene controller.
 */
public class BotLevel {
    /**
     * Battle.
     *
     * @param event the event
     */
    public void battle(ActionEvent event) {
        int botLevel = 1;
        String level = ((Button) (event.getSource())).getId();
        if (level.equals("easy")) botLevel = 1;
        if (level.equals("medium")) botLevel = 2;
        if (level.equals("hard")) botLevel = 3;

        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
            Parent root = loader.load();
            Game game = loader.getController();
            game.construct(Main.getUsers().get(0), stage, botLevel);

            Timeline updateTimeLine = new Timeline(
                    new KeyFrame(Duration.millis(250),
                            new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(javafx.event.ActionEvent event) {
                                    game.update();
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
}
