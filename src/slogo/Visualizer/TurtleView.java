package slogo.Visualizer;

import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class TurtleView extends Pane {

    private static String myBackground = "";
    private Group myGroup;
    private Pane myPane;
    private String myBackgroundSyntax;
    private String DEFAULT_BACKGROUND_COLOR = "#FFFFFF";

    public TurtleView() {
        //will convert to group for liens etc
        myGroup = new Group();
        myPane = new Pane();
        myBackgroundSyntax = "-fx-background-color: #";
        myBackground = myBackgroundSyntax + DEFAULT_BACKGROUND_COLOR;

        myPane.getChildren().addAll(myGroup);
        myPane.setBorder(new Border(new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }
    public void addGroup(Group g){
        myGroup.getChildren().addAll(g);
    }

    public void updateBackgroundColor(Color c) {
        String hex = c.toString().substring(2,10);
        myPane.setStyle(myBackgroundSyntax + hex);
        myBackground = myBackgroundSyntax + hex;
    }
    public void setBackgroundColorUsingXML(String newColor){myBackground = newColor;}

    public Pane getPane() { return myPane;}
    public static String getBackgroundColor() { return myBackground;}



}
