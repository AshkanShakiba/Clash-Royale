import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String style = getClass().getResource("menu.css").toExternalForm();
        Parent root = FXMLLoader.load(getClass().getResource("entrance.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(style);
        stage.setScene(scene);
        stage.show();
    }
}
