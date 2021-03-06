import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Random;

/**
 * The End game scene controller.
 */
public class EndGame {
    private int score1;
    private int score2;
    private User user;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView red1;
    @FXML
    private ImageView red2;
    @FXML
    private ImageView red3;

    @FXML
    private ImageView blue1;
    @FXML
    private ImageView blue2;
    @FXML
    private ImageView blue3;

    @FXML
    private ImageView botSad;
    @FXML
    private ImageView botHappy;
    @FXML
    private ImageView playerSad;
    @FXML
    private ImageView playerHappy;

    @FXML
    private Label botHp;
    @FXML
    private Label playerHp;

    /**
     * Sets scores.
     *
     * @param score1 the score 1
     * @param score2 the score 2
     */
    public void setScores(int score1, int score2) {
        this.score1 = score1;
        this.score2 = score2;


        if (score1 == 2) {
            red2.setImage(null);
        }
        if (score1 == 1) {
            red1.setImage(null);
            red3.setImage(null);
        }
        if (score1 == 0) {
            red1.setImage(null);
            red2.setImage(null);
            red3.setImage(null);
        }
        if (score2 == 2) {
            blue2.setImage(null);
        }
        if (score2 == 1) {
            blue1.setImage(null);
            blue3.setImage(null);
        }
        if (score2 == 0) {
            blue1.setImage(null);
            blue2.setImage(null);
            blue3.setImage(null);
        }

    }

    /**
     * Sets hps.
     *
     * @param hp1 the hp 1
     * @param hp2 the hp 2
     */
// hp1: Bot, hp2: Player
    public void setHps(int hp1, int hp2) {
        if (hp1 > hp2) {
            score1 = 3;
        } else if (hp1 < hp2) {
            score2 = 3;
        } else {
            hp1--;
            score2 = 3;
        }
        botHp.setText("HP: " + hp1);
        playerHp.setText("HP: " + hp2);
    }

    /**
     * Sets emotes.
     */
    public void setEmotes() {
        // Bot wins
        if (score1 > score2) {
            botSad.setImage(null);
            playerHappy.setImage(null);
            anchorPane.setStyle("-fx-background-size: 100%;-fx-background-image: url('assets/background4.png');");
        }
        // Player Wins
        else {
            botHappy.setImage(null);
            playerSad.setImage(null);
        }

    }

    /**
     * Update user data.
     */
    public void updateUserData() {
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

        game5 = game4;
        game4 = game3;
        game3 = game2;
        game2 = game1;
        game1 = score2 * 10 + score1;


        int[] games = {game1, game2, game3, game4, game5};
        for (int i = 0; i < 5; i++) {
            message = "UPDATE userdata SET Game" + (i + 1)
                    + " = '" + games[i] + "' WHERE username = '" + user.getUsername() + "'";
            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(message);

            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            }
        }

        message = "UPDATE userdata SET Xp"
                + " = '" + user.getXp() + "' WHERE username = '" + user.getUsername() + "'";
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(message);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        message = "UPDATE userdata SET Title"
                + " = '" + user.getTitle() + "' WHERE username = '" + user.getUsername() + "'";
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(message);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }


    }

    /**
     * Sets user xp.
     *
     * @param user the user
     */
    public void setUserXp(User user) {
        this.user = user;
        if (score2 > score1) this.user.increaseXp(200);
        else this.user.increaseXp(70);
    }

    /**
     * Sets user title.
     *
     * @param user the user
     */
    public void setUserTitle(User user) {
        Random random = new Random();
        int addedTitle = random.nextInt(32 - 27) + 27;

        if (score2 > score1) this.user.increaseTitle(addedTitle);
        else this.user.increaseTitle(-addedTitle);
    }

    /**
     * Menu.
     *
     * @param event the event
     */
    public void menu(ActionEvent event) {
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
