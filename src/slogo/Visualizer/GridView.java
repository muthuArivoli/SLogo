package slogo.Visualizer;

import javafx.geometry.Insets;
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
    private final static int numCols = 540 ;
    private final static int numRows = 540 ;

    public GridView() {
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        turtleSource = new Image("turtle.png");
        turtle = resizeImage(turtleSource);
        gridSizer(numCols, numRows);
        gridPane.add(turtle, 539, 539);
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
        }
        for (int i = 0; i < rows; i++) {
            RowConstraints rowConst = new RowConstraints(1);
            gridPane.getRowConstraints().add(rowConst);
        }
    }
}
