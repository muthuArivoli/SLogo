package slogo;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import slogo.Variables.CVariable;
import slogo.Visualizer.Visualizer;
import slogo.XMLSaveLoadAndExceptions.ParseXMLFile;
import slogo.XMLSaveLoadAndExceptions.XMLFileBuilder;
import slogo.configuration.Property;



public class Workspace {
    private static final int HELPLINES = 14;
    private static final int BUTTONMOVEDISTANCE = 25;
    private static final int BUTTONROTATEDISTANCE = 30;
    private static final int PALETTE_SCENE_WIDTH = 250;
    private static final int PALETTE_SCENE_HEIGHT = 500;
    private static final String PEN_UP = "Pen Up";
    private static final String PEN_DOWN = "Pen Down";
    private static final int MARGINS = 50;
    private static final Insets PADDING = new Insets(MARGINS, MARGINS, MARGINS, MARGINS);
    private static final int SECOND_SCENE_SIZE = 250;
    private static final int SLIDER_WIDTH = 135;
    private static final int SPACING = 25;
    private static final int MAX_SLIDER_VALUE = 10;
    private static final int X_OFFSET = 200;
    private static final int Y_OFFSET = 100;
    private static final String RUN_FAILED = "Run Failed";
    private static final String NOT_INITIALIZED = "File could not be properly initialized";
    private Visualizer vis;
    private FrontEndAPI fAPI;
    private Property prop = new Property();


    public Workspace(Stage primaryStage) {
        Button runButton =new Button();
        Button moveForwardButton = new Button();
        Button moveBackwardButton = new Button();
        Button turnRightButton = new Button();
        Button turnLeftButton = new Button();
        Button paletteButton = new Button();
        Button helpButton = new Button();
        Button loadEnvironmentButton = new Button();
        Button saveButton = new Button();
        Button fileButton = new Button();
        Button saveVariableButton = new Button();
        Button penButton = new Button();
        ColorPicker cPicker = new ColorPicker();
        ComboBox langSelection = new ComboBox();
        TextField loadTextField = new TextField();
        TextField saveTextField = new TextField();


        vis = new Visualizer(cPicker,runButton,saveButton,helpButton,
                paletteButton, penButton,fileButton,loadEnvironmentButton,
                langSelection,loadTextField, saveTextField,
                moveForwardButton, moveBackwardButton, turnRightButton, turnLeftButton,
                saveVariableButton);

        primaryStage.setScene(vis.getScene());
        primaryStage.setResizable(false);
        primaryStage.show();
        final FileChooser fileChooser = new FileChooser();

        fAPI= vis.getFrontEndAPI(1);

        BackEndAPI bAPI=new BackEndAPI();

        runButton.setOnAction(event -> {
            try {
                bAPI.buildAndRun(vis.getScript(), fAPI);
                vis.updateHistory(vis.getScript());
                vis.addVariables(bAPI.getVariables().getVariables());
            }
            catch(IncorrectCommandException | IllegalAccessException | InvocationTargetException | InstantiationException ice){
                vis.alertCreator("Build Failed",ice.getMessage());
            }
        });

        moveForwardButton.setOnAction(event -> {
            fAPI.forward(BUTTONMOVEDISTANCE);
        });

        moveBackwardButton.setOnAction(event -> {
            fAPI.back(BUTTONMOVEDISTANCE);
        });

        turnRightButton.setOnAction(event -> {
            fAPI.right(BUTTONROTATEDISTANCE);
        });

        turnLeftButton.setOnAction(event -> {
            fAPI.left(BUTTONROTATEDISTANCE);
        });

        penButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HBox secondaryLayout = new HBox();
                Scene secondScene = new Scene(secondaryLayout, SECOND_SCENE_SIZE, SECOND_SCENE_SIZE);

                VBox temp = new VBox(SPACING);
                temp.setPadding(PADDING);
                Slider sizeSlider = new Slider(1, MAX_SLIDER_VALUE, fAPI.getPenSize());
                sizeSlider.setMaxWidth(SLIDER_WIDTH);
                sizeSlider.setShowTickMarks(true);
                sizeSlider.setShowTickLabels(true);
                sizeSlider.setMajorTickUnit(1);
                sizeSlider.valueProperty().addListener(new ChangeListener<Number>() {
                    public void changed(ObservableValue <? extends Number > observable, Number oldValue, Number newValue) {
                        int newIntVal=newValue.intValue();
                        sizeSlider.setValue(newIntVal);
                        fAPI.setPenSize(newIntVal);
                    }
                });
                String text = (fAPI.getPenDown() == 1) ? PEN_UP : PEN_DOWN;
                Button toggle = new Button(text);
                toggle.setOnAction(event2 -> {
                    if (fAPI.getPenDown() == 1) {
                        fAPI.penUp();
                        toggle.setText(PEN_DOWN);
                    }
                    else {
                        fAPI.penDown();
                        toggle.setText(PEN_UP);
                    }

                });
                ColorPicker picker = new ColorPicker();
                picker.setValue(fAPI.getPenPaintColor());
                picker.setOnAction(event3 -> {
                    fAPI.setSelectedPenColor(picker.getValue());
                });
                temp.getChildren().addAll(sizeSlider, toggle, picker);
                secondaryLayout.getChildren().addAll(temp);

                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Pen Editor");
                newWindow.setScene(secondScene);
                newWindow.setResizable(false);

                // Set position of second window, related to primary window.
                newWindow.setX(primaryStage.getX() + X_OFFSET);
                newWindow.setY(primaryStage.getY() + Y_OFFSET);

                newWindow.show();
            }
        });

        langSelection.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                bAPI.setLanguage(t1);
            }
        });

        paletteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HBox secondaryLayout = new HBox();
                Scene secondScene = new Scene(secondaryLayout, PALETTE_SCENE_WIDTH,
                    PALETTE_SCENE_HEIGHT);

                HBox temp = fAPI.getDisplayPalette();
                secondaryLayout.getChildren().addAll(temp);

                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Palette Viewer");
                newWindow.setScene(secondScene);
                newWindow.setResizable(false);

                // Set position of second window, related to primary window.
                newWindow.setX(primaryStage.getX() + X_OFFSET);
                newWindow.setY(primaryStage.getY() + Y_OFFSET);

                newWindow.show();
            }
        });

        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Help Dialogue");
                alert.setHeaderText("Commands List");
                String result = "";
                for(int i=1; i<HELPLINES; i++){
                    String x="";
                    try {
                        x = prop.getPropValues("helpLine" + i) + "\n\n";
                    }
                    catch (Exception e){
                        vis.alertCreator(NOT_INITIALIZED,e.getMessage());
                    }
                    result += x; 
                    alert.setContentText(result);
                }
                alert.show();
            }
        });

        loadEnvironmentButton.setOnAction(e -> {
            loadEnvironment(loadTextField.getText());
            loadTextField.clear();
        });

        saveButton.setOnAction(e -> {
            XMLFileBuilder builder = new XMLFileBuilder(fAPI, vis, saveTextField.getText());
            builder.createDocument();
            saveTextField.clear();
        });

        //CHOOSE COMMAND FILE NOT WORKING RN
        fileButton.setOnAction(event -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                try {
                    bAPI.runFile(file, fAPI);
                } catch (Exception e) {
                    vis.alertCreator(RUN_FAILED, e.getMessage());
                }
            }
        });
        saveVariableButton.setOnAction(event -> {
            for (CVariable var: vis.getVariableItems())
                bAPI.getVariables().setVariable(var.getName(), var);
        });
    }

    public Visualizer getVisualizer(){
        return vis;
    }
    private void loadEnvironment(String input){
        ParseXMLFile newlyParsedFile = new ParseXMLFile(String.format("data/%s.xml", input));
        if(newlyParsedFile.getFailStatus()){
            vis.alertCreator("File failed to parse.", "Look at console for more information.");
        }
        else {

            fAPI = vis.getFrontEndAPI(newlyParsedFile.getNumTurtlesFromAnInputtedFile());
            fAPI.setBackgroundColorUsingXML(newlyParsedFile.getBackgroundColorFromAnInputtedFile());
            fAPI.setSelectedPenColor(newlyParsedFile.getPenColorFromAnInputtedFile());
            fAPI.setCurrentScriptUsingXML(newlyParsedFile.getCurrentScriptFromAnInputtedFile());
        }
        //fAPI.setPastScriptsUsingXML(newlyParsedFile.get);


    }
}
