import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

/**
 * The battle history scene controller.
 */
public class BattleHistory {
    @FXML
    private Label userScore1;

    @FXML
    private Label userLabel2;

    @FXML
    private Label userLabel3;

    @FXML
    private Label userLabel4;

    @FXML
    private Label userLabel5;

    @FXML
    private Label userLabel1;

    @FXML
    private Label userScore2;

    @FXML
    private Label userScore3;

    @FXML
    private Label userScore4;

    @FXML
    private Label userScore5;

    @FXML
    private Label botScore1;

    @FXML
    private Label botScore2;

    @FXML
    private Label botScore3;

    @FXML
    private Label botScore4;

    @FXML
    private Label botScore5;

    @FXML
    private Label xp;
    @FXML
    private Label level;
    @FXML
    private Label cups;
    @FXML
    private Label league;

    private User user;

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Show stats.
     * user's battle history
     */
    public void show() {

        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();
        HashMap<String, Integer> users = new HashMap<>();
        int game1 = 0, game2 = 0, game3 = 0, game4 = 0, game5 = 0;


        String message = "SELECT Game1, Game2, Game3, Game4, Game5" +
                " FROM userdata WHERE Username = '" + user.getUsername() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(message);

            while (queryResult.next()) {
                users.put(queryResult.getString(2), queryResult.getInt(1));
                game1 = queryResult.getInt(1);
                game2 = queryResult.getInt(2);
                game3 = queryResult.getInt(3);
                game4 = queryResult.getInt(4);
                game5 = queryResult.getInt(5);
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        userLabel1.setText(user.getUsername());
        userLabel2.setText(user.getUsername());
        userLabel3.setText(user.getUsername());
        userLabel4.setText(user.getUsername());
        userLabel5.setText(user.getUsername());

        userScore1.setText(game1 / 10 + "");
        userScore2.setText(game2 / 10 + "");
        userScore3.setText(game3 / 10 + "");
        userScore4.setText(game4 / 10 + "");
        userScore5.setText(game5 / 10 + "");

        botScore1.setText(game1 % 10 + "");
        botScore2.setText(game2 % 10 + "");
        botScore3.setText(game3 % 10 + "");
        botScore4.setText(game4 % 10 + "");
        botScore5.setText(game5 % 10 + "");

        xp.setText("XP: " + user.getXp());
        level.setText("Level: " + user.getLevel());
        cups.setText(user.getTitle() + "");
        league.setText(user.getLeague());
    }

    /**
     * Back to menu.
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
}
