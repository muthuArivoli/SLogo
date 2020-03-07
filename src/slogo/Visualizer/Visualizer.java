package slogo.Visualizer;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import slogo.FrontEndAPI;

import java.util.ArrayList;

public class Visualizer {
    private static Integer sceneLength = 800;
    private static Integer sceneWidth = 1200;

    private BorderPane rootPane;
    private Scene myScene;
    private TurtleView myTurtleView;
    private DashboardView myDashboard;
    private GUIControllerView myControls;


    public Visualizer(ColorPicker picker, Button runButton, Button saveButton, Button helpButton,
                      Button paletteButton, Button penButton, Button fileButton, Button loadEnvironmentButton,
                      ComboBox langSelection, TextField loadTextField, TextField saveTextField,
                      Button moveForwardButton, Button moveBackwardButton, Button turnRightButton, Button turnLeftButton) {

        Pane turtlePane=new Pane();
        HBox menuPane=new HBox();

        myTurtleView = new TurtleView(turtlePane);
        myDashboard = new DashboardView();
        new MenuView(menuPane,picker,runButton,saveButton,helpButton,paletteButton,penButton,fileButton,loadEnvironmentButton,langSelection,loadTextField,saveTextField);
        myControls = new GUIControllerView(moveForwardButton, moveBackwardButton, turnRightButton, turnLeftButton);
        rootPane = new BorderPane();
        myScene = new Scene(rootPane, sceneWidth, sceneLength);
        rootPane.setRight(myDashboard);
        rootPane.setCenter(turtlePane);
        rootPane.setBottom(myControls);
        rootPane.setPadding(new Insets(10,10,10,10));
        rootPane.setTop(menuPane);
    }

//    public Property getProperty(ButtonProperty type) {
//        return switch (type) {
//            case RUN -> myRunProperty;
//        }
//    }
    public Scene getScene() {return myScene;}

    public FrontEndAPI getFrontEndAPI(int amount){
        ArrayList<Integer> activeTurtles =new ArrayList<>();
        activeTurtles.add(1);
        return new FrontEndAPI(myTurtleView, myDashboard, amount, activeTurtles);
    }

    public void updateHistory(String script) {
        myDashboard.getPastScript().addScript(script);
    }


    public String getScript(){return myDashboard.getScript();}

    public static Integer getSceneLength(){return sceneLength;}


    public static Integer getSceneWidth(){return sceneWidth;}


    public void alertCreator(String message1, String message2) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(message1);
        alert.setContentText(message2);
        alert.showAndWait();
    }
}
