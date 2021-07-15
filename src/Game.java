import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class Game {
    @FXML
    private AnchorPane leftPane;
    @FXML
    private AnchorPane middlePane;
    @FXML
    private AnchorPane rightPane;

    private double x, y;
    private Card selected;

    public void click(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
