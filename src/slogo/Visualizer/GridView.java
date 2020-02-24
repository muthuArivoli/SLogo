package slogo.Visualizer;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;

public class GridView extends Pane {

    private GridPane gridPane;
    private Image turtleSource;
    private ImageView turtle;
    private final static int numCols = 572 ;
    private final static int numRows = 572 ;

    public GridView() {
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(0, 0, 0, 0));
        turtleSource = new Image("turtle.png");
        turtle = resizeImage(turtleSource);
        gridSizer(numCols, numRows);
        gridPane.add(turtle, 571, 571);
        GridPane.setHalignment(turtle, HPos.CENTER);
        GridPane.setValignment(turtle, VPos.CENTER);

    }

    public GridPane getPane() {return gridPane;}

    private ImageView resizeImage(Image input) {
        ImageView result = new ImageView();
        result.setImage(input);
        result.setFitWidth(30);
        result.setPreserveRatio(true);
        result.setSmooth(true);
        result.setCache(true);
        return result;
    }

    private void gridSizer(int cols, int rows) {
        for (int i = 0; i < cols; i++) {
            ColumnConstraints colConst = new ColumnConstraints(1);
            gridPane.getColumnConstraints().add(colConst);
            colConst.setHgrow(Priority.NEVER);

        }
        for (int i = 0; i < rows; i++) {
            RowConstraints rowConst = new RowConstraints(1);
            gridPane.getRowConstraints().add(rowConst);
            rowConst.setVgrow(Priority.NEVER);
        }
    }
}
