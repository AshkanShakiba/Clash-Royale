import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    private static ArrayList<User> users = new ArrayList<>();

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void printUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Entrance.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
            event.consume();
            exit(stage);
        });
    }

    public static void exit(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Unsaved data will be fucked");
        alert.setContentText("Are you sure to exit?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
            System.exit(0);
        }
    }
}
