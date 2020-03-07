package slogo.Visualizer;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

<<<<<<< HEAD
public class TurtleView{

    private static String myBackground;
    private Pane myPane;
    private String myBackgroundSyntax;
=======
public class TurtleView extends Pane {
    private static final String myBackgroundSyntax = "-fx-background-color: #";
    private static final String DEFAULT_BACKGROUND_COLOR = "#FFFFFF";
    private static final Pane myPane = new Pane();
    private String myBackground;
    private Group myGroup;
>>>>>>> jdm

    public TurtleView(Pane p) {
        //will convert to group for liens etc
<<<<<<< HEAD
        myPane = p;
        myBackgroundSyntax = "-fx-background-color: #";
=======
        myGroup = new Group();
        //myPane = new Pane();
        myBackground = myBackgroundSyntax + DEFAULT_BACKGROUND_COLOR;
>>>>>>> jdm

        myPane.setBorder(new Border(new BorderStroke(Color.WHITE,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    public void addGroup(Group toAdd){
        myPane.getChildren().addAll(toAdd);
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

<<<<<<< HEAD

    public int getWidth(){
        return (int) myPane.getWidth();
    }

    public int getHeight(){
        return (int) myPane.getHeight();
    }

=======
    public Pane getPane() { return myPane;}
>>>>>>> jdm
    public String getBackgroundColor() {return myBackground;}



}
