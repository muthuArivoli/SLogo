package slogo.Visualizer;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class Visualizer {

    private BorderPane rootPane;
    private Scene myScene;

    public Visualizer(ImageView turtleImage) {
        GridView myGrid = new GridView(turtleImage);
        ScriptView myScript = new ScriptView();
        MenuView myMenu = new MenuView();

        rootPane = new BorderPane();
        myScene = new Scene(rootPane, 800, 600);
        rootPane.setRight(myScript.getPane());
        rootPane.setCenter(myGrid.getPane());
        rootPane.setTop(myMenu.getPane());


    }

    public Scene getScene() {return myScene;}
}
