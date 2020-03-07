package slogo.Visualizer;

import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class TurtleView{

    private String myBackground;
    private Pane myPane;
    private String myBackgroundSyntax;

    public TurtleView(Pane p) {
        //will convert to group for liens etc
        myPane = p;
        myBackgroundSyntax = "-fx-background-color: #";

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

    public int getWidth(){
        return (int) myPane.getWidth();
    }

    public int getHeight(){
        return (int) myPane.getHeight();
    }

    public String getBackgroundColor() {return myBackground;}



}
