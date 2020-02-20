package slogo.Visualizer;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GridView extends Pane {

    private GridPane gridPane;

    public GridView() {
        gridPane = new GridPane();
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);
        gridPane.getColumnConstraints().addAll(column1, column2);
    }

    public GridPane getPane() {return gridPane;}
}
