import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * The leader board scene controller.
 */
public class LeaderBoard implements Initializable {

    @FXML
    private Label username1;

    @FXML
    private Label username2;

    @FXML
    private Label username3;

    @FXML
    private Label username4;

    @FXML
    private Label username5;

    @FXML
    private Label username6;

    @FXML
    private Label crown1;

    @FXML
    private Label crown2;

    @FXML
    private Label crown3;

    @FXML
    private Label crown4;

    @FXML
    private Label crown5;

    @FXML
    private Label crown6;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();
        HashMap<String, Integer> users = new HashMap<>();


        String message = "SELECT Title, Username FROM userdata";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(message);

            while (queryResult.next()) {
                users.put(queryResult.getString(2), queryResult.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(users.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }

        users = temp;

        int i = 0;

        for (String key : users.keySet()) {
            i++;
            //System.out.println(key + " " + users.get(key));
            switch (i) {
                case 1: {
                    username1.setText(key);
                    crown1.setText(users.get(key) + "");
                    break;
                }
                case 2: {
                    username2.setText(key);
                    crown2.setText(users.get(key) + "");
                    break;
                }
                case 3: {
                    username3.setText(key);
                    crown3.setText(users.get(key) + "");
                    break;
                }
                case 4: {
                    username4.setText(key);
                    crown4.setText(users.get(key) + "");
                    break;
                }
                case 5: {
                    username5.setText(key);
                    crown5.setText(users.get(key) + "");
                    break;
                }
                case 6: {
                    username6.setText(key);
                    crown6.setText(users.get(key) + "");
                    break;
                }
            }
        }

    }

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
}
