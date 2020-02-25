package slogo.Visualizer;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;

public class GridView extends Pane {

    private Group myGroup;
    private Pane myPane;


    public GridView(ImageView turtleImage) {
        //will convert to group for liens etc
        myGroup = new Group();
        myGroup.getChildren().addAll(turtleImage);
        myPane = new Pane();
        myPane.getChildren().addAll(myGroup);
        myPane.setPrefSize(200, 200);

    }

    public Pane getPane() {return myPane;}

}
