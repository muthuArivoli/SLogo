package slogo.Visualizer;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import slogo.FrontEndAPI;
import slogo.Variables.CVariable;

public class Visualizer {
    private final static Integer sceneLength = 800;
    private final static Integer sceneWidth = 1200;
    private static final int MARGINS = 10;
    private static final Insets PADDING = new Insets(MARGINS, MARGINS, MARGINS, MARGINS);
    private static final String ERROR = "error";

    private Scene myScene;
    private TurtleView myTurtleView;
    private DashboardView myDashboard;

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
        GUIControllerView myControls = new GUIControllerView(moveForwardButton, moveBackwardButton, turnRightButton, turnLeftButton);
        BorderPane rootPane = new BorderPane();
        myScene = new Scene(rootPane, sceneWidth, sceneLength);
        rootPane.setRight(myDashboard);

        rootPane.setCenter(turtlePane);
        rootPane.setBottom(myControls);
        rootPane.setPadding(PADDING);
        rootPane.setTop(menuPane);
    }

    public Scene getScene() {return myScene;}

    /**
     * returns front end api for active turtles
     * @param amount
     * @return
     */
    public FrontEndAPI getFrontEndAPI(int amount){
        ArrayList<Integer> activeTurtles = new ArrayList<>();
        activeTurtles.add(1);
        return new FrontEndAPI(myTurtleView, myDashboard, amount, activeTurtles);
    }

    public void updateHistory(String script) {
        myDashboard.getPastScript().addScript(script);
    }


    public String getScript(){return myDashboard.getScript();}
    public ObservableList<CVariable> getVariableItems() {
        return myDashboard.getVariableTable().getItems();
    }

    public void addVariables(List<CVariable> variables) {
        myDashboard.getVariableTable().getItems().setAll(variables);
    }

    /**
     * Used to create alert popup boxes when exceptions are caught
     * @param message1 header of popup box
     * @param message2 shows error message
     */
    public void alertCreator(String message1, String message2) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(ERROR);
        alert.setHeaderText(message1);
        alert.setContentText(message2);
        alert.showAndWait();
    }
}
