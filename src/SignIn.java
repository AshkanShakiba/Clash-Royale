import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


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



    public void signInButtonOnAction(ActionEvent event){

        if(usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false){
            signInMessage.setText("You tried to login!");
            validateSignIn();
        }else {
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
        createAccountForm();

    }


    public void validateSignIn(){
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifySignIn = "SELECT count(1) FROM userdata WHERE username = '"
                + usernameTextField.getText() + "' AND password = '" + passwordTextField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifySignIn);

            while (queryResult.next()){
                if(queryResult.getInt(1) == 1){
                    signInMessage.setText("Congratulations!");
                }else {
                    signInMessage.setText("Please enter a valid password and username!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void createAccountForm(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("signUp.Fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.DECORATED);
            registerStage.setScene(new Scene(root, 750, 500));
            registerStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            e.getCause();
        }
    }


}
