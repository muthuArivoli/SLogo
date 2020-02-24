package slogo.Visualizer;

import javafx.beans.property.Property;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import slogo.Visualizer.MenuView.ButtonProperty;

public class Visualizer {

    private BorderPane rootPane;
    private Scene myScene;

    public Visualizer() {
        GridView myGrid = new GridView();
        ScriptView myScript = new ScriptView();
        MenuView myMenu = new MenuView();

        rootPane = new BorderPane();
        myScene = new Scene(rootPane, 800, 600);
        rootPane.setRight(myScript.getPane());
        rootPane.setCenter(myGrid.getPane());
        rootPane.setTop(myMenu.getPane());
    }

//    public Property getProperty(ButtonProperty type) {
//        return switch (type) {
//            case RUN -> myRunProperty;
//        }
//    }
    public Scene getScene() {return myScene;}
}
