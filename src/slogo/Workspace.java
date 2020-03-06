package slogo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import slogo.Visualizer.Visualizer;
import slogo.XMLSaveLoadAndExceptions.ParseXMLFile;
import slogo.XMLSaveLoadAndExceptions.XMLFileBuilder;

import java.io.File;

public class Workspace {
    private Visualizer vis;
    private FrontEndAPI fAPI;


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
        Button penButton = new Button();
        ColorPicker cPicker = new ColorPicker();
        ComboBox langSelection = new ComboBox();
        TextField loadTextField = new TextField();
        TextField saveTextField = new TextField();


        vis = new Visualizer(cPicker,runButton,saveButton,helpButton,
                paletteButton, penButton,fileButton,loadEnvironmentButton,
                langSelection,loadTextField, saveTextField,
                moveForwardButton, moveBackwardButton, turnRightButton, turnLeftButton);

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
            }
            catch(IncorrectCommandException ice){
                vis.alertCreator("Build Failed",ice.getMessage());
            }
        });

        moveForwardButton.setOnAction(event -> {
            fAPI.forward(25);
        });

        moveBackwardButton.setOnAction(event -> {
            fAPI.back(25);
        });

        turnRightButton.setOnAction(event -> {
            fAPI.right(30);
        });

        turnLeftButton.setOnAction(event -> {
            fAPI.left(30);
        });

        penButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HBox secondaryLayout = new HBox();
                Scene secondScene = new Scene(secondaryLayout, 250, 250);

                VBox temp = new VBox(25);
                temp.setPadding(new Insets(50,57,50,57));
                Slider sizeSlider = new Slider(1, 10, fAPI.getPenSize());
                sizeSlider.setMaxWidth(135);
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
                String text = (fAPI.getPenDown() == 1) ? "Pen Up" : "Pen Down";
                Button toggle = new Button(text);
                toggle.setMinWidth(130);
                toggle.setOnAction(event2 -> {
                    if (fAPI.getPenDown() == 1) {
                        fAPI.penUp();
                        toggle.setText("Pen Down");
                    }
                    else {
                        fAPI.penDown();
                        toggle.setText("Pen Up");
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
                newWindow.setX(primaryStage.getX() + 200);
                newWindow.setY(primaryStage.getY() + 100);

                newWindow.show();
            }
        });

        langSelection.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                bAPI.setLanguage(t1);
            }
        });

        paletteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HBox secondaryLayout = new HBox();
                Scene secondScene = new Scene(secondaryLayout, 250, 500);

                HBox temp = fAPI.getDisplayPalette();
                secondaryLayout.getChildren().addAll(temp);

                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Palette Viewer");
                newWindow.setScene(secondScene);
                newWindow.setResizable(false);

                // Set position of second window, related to primary window.
                newWindow.setX(primaryStage.getX() + 200);
                newWindow.setY(primaryStage.getY() + 100);

                newWindow.show();
            }
        });

        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Help Dialogue");
                alert.setHeaderText("Commands List");
                alert.setContentText("FORWARD/FD                [pixels]\n\n" +
                        "BACK/BK                           [pixels]\n\n" +
                        "LEFT/LT                             [degrees]\n\n" +
                        "RIGHT/RT                          [degrees]\n\n" +
                        "SETHEADING/SETH     [degrees]\n\n" +
                        "TOWARDS                        [x y]\n\n" +
                        "SETXY/GOTO                  [x y]\n\n" +
                        "PENDOWN/PD\n\n" +
                        "PENUP/PU\n\n" +
                        "SHOWTURTLE/ST\n\n" +
                        "HIDETURTLE/HT\n\n" +
                        "HOME\n\n" +
                        "CLEARSCREEN/CS\n\n");
                alert.show();
            }
        });

        loadEnvironmentButton.setOnAction(e -> loadEnvironment(loadTextField.getText()));

        saveButton.setOnAction(e -> {
            XMLFileBuilder builder = new XMLFileBuilder(fAPI.turtles(), fAPI.getStringBackgroundColor(), saveTextField.getText());
            builder.createDocument();
        });

        //CHOOSE COMMAND FILE NOT WORKING RN
        fileButton.setOnAction(event -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                bAPI.runFile(file, fAPI);
            }
        });
    }

    public Visualizer getVisualizer(){
        return vis;
    }
    private void loadEnvironment(String input){
        ParseXMLFile newlyParsedFile = new ParseXMLFile(String.format("data/%s.xml", input));
        fAPI=vis.getFrontEndAPI(newlyParsedFile.getNumTurtlesFromAnInputtedFile());
        fAPI.setBackgroundColorUsingXML(newlyParsedFile.getBackgroundColorFromAnInputtedFile());
    }
}
