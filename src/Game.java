import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public class Game {
    @FXML
    GridPane gridPane;

    public void select(ActionEvent event) {
        Node clickedNode = (Node) event.getSource();
        Integer colIndex = GridPane.getColumnIndex(clickedNode);
        Integer rowIndex = GridPane.getRowIndex(clickedNode);
        System.out.println("Mouse clicked cell: " + colIndex + " And: " + rowIndex);
    }
}
