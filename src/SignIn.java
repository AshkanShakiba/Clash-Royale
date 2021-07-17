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
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class SignIn {

    @FXML
    private ImageView signUpGradiant;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button layer1signInButton;
    @FXML
    private Button layer1signUpButton;
    @FXML
    private Label signInMessage;
    @FXML
    private Label layer1label1;
    @FXML
    private Label layer1label2;
    @FXML
    private Label layer1label3;
    @FXML
    private Label layer1label4;
    @FXML
    private ImageView layer1Image;
    @FXML
    private Label layer1usernameLable;
    @FXML
    private Label layer1passwordLable;


    public void signInButtonOnAction(ActionEvent event) {

        if (usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false) {
            signInMessage.setText("You tried to login!");
            if(validateSignIn()){
                Main.getUsers().add(currentUser());
                Main.printUsers();
                goToBattleDeck(event);
            }
        } else {
            signInMessage.setText("please enter password & username");
        }


    }

    public void signUpButtonOnAction(ActionEvent event) {
        /*
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(signUpGradiant);

        slide.setToX(450);
        slide.play();

        layer1label1.setVisible(false);
        layer1label2.setVisible(false);
        layer1label3.setVisible(false);
        layer1label4.setVisible(false);
        layer1usernameTextField.setVisible(false);
        passwordTextField.setVisible(false);
        layer1Image.setVisible(false);
        layer1passwordLable.setVisible(false);
        layer1usernameLable.setVisible(false);
         */
        createAccountForm(event);

    }

    public boolean validateSignIn() {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifySignIn = "SELECT count(1) FROM userdata WHERE username = '"
                + usernameTextField.getText() + "' AND password = '" + passwordTextField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifySignIn);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    signInMessage.setText("Congratulations!");
                    return true;
                } else {
                    signInMessage.setText("Please enter a valid password and username!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return false;
    }

    public void createAccountForm(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signUp.fxml"));
            Parent root = loader.load();
            SignUp signUp = loader.getController();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //stage.initStyle(StageStyle.DECORATED);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void goToBattleDeck(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BattleDeck.fxml"));
            Parent root = loader.load();
            BattleDeck battleDeck = loader.getController();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            //stage.initStyle(StageStyle.DECORATED);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public User currentUser(){
        String[] currentCards = new String[8];
        int xp  = 0;
        User user = null;
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifySignIn = "SELECT * FROM userdata WHERE username = '"
                + usernameTextField.getText() + "' AND password = '" + passwordTextField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifySignIn);

            while (queryResult.next()) {
                xp = queryResult.getInt(4);
                for(int i = 5; i < 12; i++){
                    currentCards[i-5] = (queryResult.getString(i));
                }
            }

            user = new User(usernameTextField.getText(), xp, currentCards);

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return user;
    }




}
