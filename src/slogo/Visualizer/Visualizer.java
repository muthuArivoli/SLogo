package slogo.Visualizer;

import java.util.List;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import slogo.FrontEndAPI;
import slogo.configuration.Property;

import java.util.ArrayList;
import slogo.Variables.CVariable;

public class Visualizer {
    private static Integer sceneLength = 800;
    private static Integer sceneWidth = 1200;

    private BorderPane rootPane;
    private Scene myScene;
    private TurtleView myTurtleView;
    private DashboardView myDashboard;
    private GUIControllerView myControls;
    private Property prop = new Property();

    public Visualizer(ColorPicker picker, Button runButton, Button saveButton, Button helpButton,
                      Button paletteButton, Button penButton, Button fileButton, Button loadEnvironmentButton,
                      ComboBox langSelection, TextField loadTextField, TextField saveTextField,
                      Button moveForwardButton, Button moveBackwardButton, Button turnRightButton, Button turnLeftButton,
                      Button saveVariablesButton) {

        Pane turtlePane=new Pane();
        HBox menuPane=new HBox();

        picker.setOnAction(event -> {
            myTurtleView.updateBackgroundColor(picker.getValue());
        });

        myTurtleView = new TurtleView(turtlePane);
        myDashboard = new DashboardView(saveVariablesButton);
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

<<<<<<< HEAD

=======
    public Button getRunButton(){return myMenu.getRunButton();}
    public ComboBox getLangSelection(){return myMenu.getLangSelection();}
    public Button getPaletteButton(){return myMenu.getPaletteButton();}
    public Button getFileButton(){return myMenu.getFileButton();}
    public Button getPenButton(){return myMenu.getPenButton();}
    public Button getHelpButton(){return myMenu.getHelpButton();}
    public Button getMoveForwardButton(){return myControls.getMoveForwardButton();}
    public Button getMoveBackwardButton(){return myControls.getMoveBackwardButton();}
    public Button getTurnRightButton(){return myControls.getTurnRightButton();}
    public Button getTurnLeftButton(){return myControls.getTurnLeftButton();}
    public Button getSaveButton(){return myMenu.getSaveButton();}
    public Button getLoadEnvironmentButtonButton(){return myMenu.getLoadEnvironmentButtonButton();}
    public TextField getSaveTextField(){return myMenu.getSaveTextField();}
    public TextField getLoadTextField(){return myMenu.getLoadTextField();}
    public String getBackgroundColor() {return myTurtleView.getBackgroundColor();}
    public void setBackgroundColorUsingXML(String newColor){myTurtleView.setBackgroundColorUsingXML(newColor); }
>>>>>>> jdm
    public String getScript(){return myDashboard.getScript();}

    public void setScript(String input) {myDashboard.setScript(input);}

    public ObservableList<CVariable> getVariableItems() {
        return myDashboard.getVariableTable().getItems();
    }

    public void addVariables(List<CVariable> variables) {
        myDashboard.getVariableTable().getItems().setAll(variables);
    }
    public static Integer getSceneLength(){return sceneLength;}

    public static Integer getSceneWidth(){return sceneWidth;}

    public void alertCreator(String message1, String message2) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(prop.getPropValues("error"));
        alert.setHeaderText(message1);
        alert.setContentText(message2);
        alert.showAndWait();
    }
}
