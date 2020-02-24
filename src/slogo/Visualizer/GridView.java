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
        turtle = centerImage(turtle);
        gridSizer(numCols, numRows);
        gridPane.add(turtle, numCols/2, numRows/2);
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

    public ImageView centerImage(ImageView input) {
        Image img = input.getImage();
        if (img != null) {
            double w = 0;
            double h = 0;

            double ratioX = input.getFitWidth() / img.getWidth();
            double ratioY = input.getFitHeight() / img.getHeight();

            double reducCoeff = 0;
            if(ratioX >= ratioY) {
                reducCoeff = ratioY;
            } else {
                reducCoeff = ratioX;
            }

            w = img.getWidth() * reducCoeff;
            h = img.getHeight() * reducCoeff;

            input.setX((input.getFitWidth() - w) / 2);
            input.setY((input.getFitHeight() - h) / 2);
        }
        return input;
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
