package slogo.Visualizer;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import slogo.Turtle;

import java.awt.*;

public class Visualizer {

    private BorderPane rootPane;
    private Scene myScene;
    private TurtleView myTurtleView;
    private MenuView myMenu;
    private DashboardView myDashboard;


    public Visualizer() {

        myTurtleView = new TurtleView();
        myDashboard = new DashboardView();
        myMenu = new MenuView(myTurtleView);

        rootPane = new BorderPane();
        myScene = new Scene(rootPane, 1200, 800);
        rootPane.setRight(myDashboard.getDashboardPane());
        rootPane.setCenter(myTurtleView.getPane());
        rootPane.setPadding(new Insets(10,10,10,10));
        rootPane.setTop(myMenu.getPane());
    }

//    public Property getProperty(ButtonProperty type) {
//        return switch (type) {
//            case RUN -> myRunProperty;
//        }
//    }
    public Scene getScene() {return myScene;}

    public Turtle addTurtle(){
        Turtle t =new Turtle((int) myTurtleView.getPane().getWidth(), (int) myTurtleView.getPane().getHeight());
        myTurtleView.addGroup(t.getTurtleGroup());
        return t;
    }
    public void updateHistory(String script) {
        myDashboard.getPastScript().addScript(script);
    }

    public Button getRunButton(){return myMenu.getRunButton();}
    public ComboBox getLangSelection(){return myMenu.getLangSelection();}
    public Button getFileButton(){return myMenu.getFileButton();}
    public Button getHelpButton(){return myMenu.getHelpButton();}
    public String getScript(){return myDashboard.getScript();}

    public void alertCreator(String message1, String message2) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(message1);
        alert.setContentText(message2);
        alert.showAndWait();
    }
}
