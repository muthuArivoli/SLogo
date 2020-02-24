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

    public GridView() {
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        turtleSource = new Image("turtle.png");
        turtle = resizeImage(turtleSource);

        gridPane.setGridLinesVisible(false);
        final int numCols = 540 ;
        final int numRows = 540 ;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints(1);
            gridPane.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints(1);
            gridPane.getRowConstraints().add(rowConst);
        }

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
}
