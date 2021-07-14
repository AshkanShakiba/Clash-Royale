import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GameView extends Group {
    public final static double CELL_WIDTH = 20.0;

    private final int rowCount = 38;
    private final int columnCount = 55;

    private ImageView[][] cellViews;
    private Image archerImage;
    private Image arrowsImage;
    private Image babyDragonImage;
    private Image barbariansImage;
    private Image cannonImage;
    private Image fireballImage;
    private Image giantImage;
    private Image infernoTowerImage;
    private Image miniPekkaImage;
    private Image rageImage;
    private Image valkyrieImage;
    private Image wizardImage;

    public GameView() {
        this.archerImage = new Image(getClass().getResourceAsStream("/assets/archer.png"));
        this.arrowsImage = new Image(getClass().getResourceAsStream("/assets/arrows.png"));
        this.babyDragonImage = new Image(getClass().getResourceAsStream("/assets/babyDragon.png"));
        this.barbariansImage = new Image(getClass().getResourceAsStream("/assets/barbarians.png"));
        this.cannonImage = new Image(getClass().getResourceAsStream("/assets/cannon.png"));
        this.fireballImage = new Image(getClass().getResourceAsStream("/assets/fireballImage.png"));
        this.giantImage = new Image(getClass().getResourceAsStream("/assets/giant.png"));
        this.infernoTowerImage = new Image(getClass().getResourceAsStream("/assets/infernoTower.png"));
        this.miniPekkaImage = new Image(getClass().getResourceAsStream("/assets/miniPekka.png"));
        this.rageImage = new Image(getClass().getResourceAsStream("/assets/rage.png"));
        this.valkyrieImage = new Image(getClass().getResourceAsStream("/assets/valkyrie.png"));
        this.wizardImage = new Image(getClass().getResourceAsStream("/assets/wizard.png"));
    }

    private void initializeGrid() {
        this.cellViews = new ImageView[this.rowCount][this.columnCount];
        for (int row = 0; row < this.rowCount; row++) {
            for (int column = 0; column < this.columnCount; column++) {
                ImageView imageView = new ImageView();
                imageView.setX((double)column * CELL_WIDTH);
                imageView.setY((double)row * CELL_WIDTH);
                imageView.setFitWidth(CELL_WIDTH);
                imageView.setFitHeight(CELL_WIDTH);
                this.cellViews[row][column] = imageView;
                this.getChildren().add(imageView);
            }
        }
    }

    public void update(/*bullshit*/){
    }

}
