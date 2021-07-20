import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SignUp {

    @FXML
    private ImageView signUpGradiant;

    @FXML
    private Button layer2signInButton;

    @FXML
    private AnchorPane SignUpLayer;

    @FXML
    private TextField layer2usernameTextField;

    @FXML
    private PasswordField layer2passwordTextField;

    @FXML
    private Label layer2usernameLable;

    @FXML
    private Label layer2passwordLable;

    @FXML
    private ImageView layer2Image;

    @FXML
    private Label signUpMessage;

    @FXML
    private Button layer2signUpButton;

    @FXML
    public void signInButtonOnAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signIn.fxml"));
            Parent root = loader.load();
            SignIn signIn = loader.getController();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //stage.initStyle(StageStyle.DECORATED);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    public void signUpButtonOnAction(ActionEvent event) {
        if (layer2usernameTextField.getText().isBlank() == false && layer2passwordTextField.getText().isBlank() == false) {
            signUpMessage.setText("You tried to register!");
            registerUser();
        } else {
            signUpMessage.setText("please enter password & username");
        }
    }

    public boolean registerUser() {

        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        String username = layer2usernameTextField.getText();
        String password = layer2passwordTextField.getText();

        String verifySignIn = "SELECT count(1) FROM userdata WHERE username = '"
                + username + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifySignIn);

            while (queryResult.next()) {
                if (queryResult.getInt(1) > 0) {
                    signUpMessage.setText("This username already exists!");
                    return false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }


        String insertFields = "INSERT INTO userdata" +
                " (username, password, Xp, Card1, Card2, Card3, Card4, Card5, Card6, Card7, Card8, Title) VALUES ('";
        String insertValues = username + "','" + password + "','" + 0 + "','','','','','','','','','" + 0 + "')";
        String insertToDB = insertFields + insertValues;
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToDB);
            signUpMessage.setText("Congratulations!");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return true;

    }

}
