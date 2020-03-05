package slogo.Visualizer;

import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class TurtleView extends Pane {
    private static final String myBackgroundSyntax = "-fx-background-color: #";
    private static final String DEFAULT_BACKGROUND_COLOR = "#FFFFFF";
    private static String myBackground;
    private Group myGroup;
    private Pane myPane;

    public TurtleView() {
        //will convert to group for liens etc
        myGroup = new Group();
        myPane = new Pane();
        myBackground = myBackgroundSyntax + DEFAULT_BACKGROUND_COLOR;

        myPane.getChildren().addAll(myGroup);
        myPane.setBorder(new Border(new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }
    public void addGroup(Group g){
        myGroup.getChildren().addAll(g);
    }

    public void updateBackgroundColor(Color c) {
        System.out.println(c);
        String hex = c.toString().substring(2,8);
        myBackground = myBackgroundSyntax + hex;
        myPane.setStyle(myBackground);
    }
    public void setBackgroundColorUsingXML(String newColor){
        myBackground = newColor;
        myPane.setStyle(myBackground);
    }

    public Pane getPane() { return myPane;}
    public static String getBackgroundColor() {return myBackground;}



}
