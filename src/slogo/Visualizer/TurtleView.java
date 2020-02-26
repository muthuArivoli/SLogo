package slogo.Visualizer;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.*;

public class TurtleView extends Pane {

    private Group myGroup;
    private Pane myPane;


    public TurtleView() {
        //will convert to group for liens etc
        myGroup = new Group();
        myPane = new Pane();
        myPane.getChildren().addAll(myGroup);
        myPane.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }
    public void addGroup(Group g){
        myGroup.getChildren().addAll(g);
    }

    public void updateBackgroundColor(Color c) {
        String hex = c.toString().substring(2,10);
        myPane.setStyle("-fx-background-color: #" + hex);
    }

    public Pane getPane() {return myPane;}

}
