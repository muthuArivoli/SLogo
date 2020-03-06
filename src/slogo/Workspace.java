package slogo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import slogo.Visualizer.TurtleView;
import slogo.Visualizer.Visualizer;
import slogo.Visualizer.paletteMap;
import slogo.XMLSaveLoadAndExceptions.ParseXMLFile;
import slogo.XMLSaveLoadAndExceptions.XMLFileBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
        ColorPicker cPicker = new ColorPicker();
        ComboBox langSelection = new ComboBox();
        TextField loadTextField = new TextField();
        TextField saveTextField = new TextField();


        paletteMap colors = new paletteMap();
        vis = new Visualizer(cPicker,runButton,saveButton,helpButton,paletteButton,fileButton,loadEnvironmentButton,langSelection,loadTextField,saveTextField);
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
            fAPI.forward(30);
        });
        vis.getPenButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HBox secondaryLayout = new HBox();
                Scene secondScene = new Scene(secondaryLayout, 250, 250);

                VBox temp = new VBox(25);
                temp.setPadding(new Insets(50,57,50,57));
                Slider slider1 = new Slider(1, 10, t.get(0).getPenWidth());
                slider1.setMaxWidth(135);
                slider1.setShowTickMarks(true);
                slider1.setShowTickLabels(true);
                slider1.valueProperty().addListener(new ChangeListener<Number>() {
                    public void changed(ObservableValue <? extends Number > observable, Number oldValue, Number newValue) {
                        double newValue2 = newValue.doubleValue();
                        for (Turtle turtle : t) {
                            turtle.setPenWidth(newValue2);
                        }

                    }
                });
                String text = (t.get(0).getPenDown() == 1) ? "Pen Up" : "Pen Down";
                Button toggle = new Button(text);
                toggle.setMinWidth(130);
                toggle.setOnAction(event2 -> {
                    for (Turtle turtle : t)  {
                        if (turtle.getPenDown() == 1) {
                            turtle.penUp();
                            toggle.setText("Pen Down");
                        }
                        else {
                            turtle.penDown();
                            toggle.setText("Pen Up");
                        }

                    }
                });
                ColorPicker picker = new ColorPicker();
                picker.setValue(t.get(0).getPenColor());
                picker.setOnAction(event3 -> {
                    for (Turtle turtle : t)  {
                        turtle.setPenColor(picker.getValue());
                    }
                });
                temp.getChildren().addAll(slider1, toggle, picker);
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
        vis.getLangSelection().valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                bAPI.setLanguage(t1);
            }
        });
        paletteButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HBox secondaryLayout = new HBox();
                Scene secondScene = new Scene(secondaryLayout, 250, 500);

                HBox temp = new HBox();
                temp = pMap.createScene(temp);
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
