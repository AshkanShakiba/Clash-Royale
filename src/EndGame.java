import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class EndGame {
    private int score1;
    private int score2;

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

    public void setScores(int score1,int score2){
        this.score1=score1;
        this.score2=score2;

        if(score1==2){
            red2.setImage(null);
        }
        if(score1==1){
            red1.setImage(null);
            red3.setImage(null);
        }
        if(score1==0){
            red1.setImage(null);
            red2.setImage(null);
            red3.setImage(null);
        }
        if(score2==2){
            blue2.setImage(null);
        }
        if(score2==1){
            blue1.setImage(null);
            blue3.setImage(null);
        }
        if(score2==0){
            blue1.setImage(null);
            blue2.setImage(null);
            blue3.setImage(null);
        }
    }
}
