import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * The starting class of program.
 */
public class Main extends Application {
    private static User user;

    private static Theme theme = Theme.DEFAULT;

    private static ArrayList<User> users = new ArrayList<>();

    /**
     * Gets users.
     *
     * @return the users
     */
    public static ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Print users.
     */
    public static void printUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Exit.
     *
     * @param stage the stage
     */
    public static void exit(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Unsaved data won't be saved");
        alert.setContentText("Are you sure to exit?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            stage.close();
            System.exit(0);
        }
    }

    /**
     * Gets theme.
     *
     * @return the theme
     */
    public static Theme getTheme() {
        return theme;
    }

    /**
     * Sets theme.
     *
     * @param selectedTheme the selected theme
     */
    public static void setTheme(Theme selectedTheme) {
        theme = selectedTheme;
    }

    /**
     * Sets user.
     *
     * @param userInput the user input
     */
    public static void setUser(User userInput) {
        user = userInput;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Entrance.fxml"));
        stage.getIcons().add(new Image("assets/icon.jpg"));
        stage.setTitle("Clash Royale");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> {
            event.consume();
            exit(stage);
        });
    }
}
