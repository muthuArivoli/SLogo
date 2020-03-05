package slogo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import slogo.Visualizer.Visualizer;
import slogo.Visualizer.paletteMap;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Workspace {
    private Visualizer vis;
    private List<Turtle> t;
    public Workspace(Stage primaryStage) {
        paletteMap colors = new paletteMap();
        vis = new Visualizer();
        primaryStage.setScene(vis.getScene());
        primaryStage.setResizable(false);
        primaryStage.show();
        final FileChooser fileChooser = new FileChooser();

        t = new ArrayList<>();
        t.add(vis.addTurtle(t.size()));

        BackEndAPI bAPI=new BackEndAPI();
        vis.getRunButton().setOnAction(event -> {
            try {
                for(Turtle turtle:t) {
                    if (turtle.isActive()) {
                        bAPI.buildAndRun(vis.getScript(), turtle);
                    }
                }
                vis.updateHistory(vis.getScript());
            }
            catch(IncorrectCommandException ice){
                vis.alertCreator("Build Failed",ice.getMessage());
            }
        });
        vis.getMoveForwardButton().setOnAction(event -> {
            for(Turtle turtle:t) {
                if (turtle.isActive()) {
                    turtle.forward(25);
                }
            }
        });
        vis.getMoveBackwardButton().setOnAction(event -> {
            for(Turtle turtle:t) {
                if (turtle.isActive()) {
                    turtle.back(25);
                }
            }
        });
        vis.getTurnRightButton().setOnAction(event -> {
            for(Turtle turtle:t) {
                if (turtle.isActive()) {
                    turtle.right(30);
                }
            }
        });
        vis.getTurnLeftButton().setOnAction(event -> {
            for(Turtle turtle:t) {
                if (turtle.isActive()) {
                    turtle.left(30);
                }
            }
        });
        vis.getLangSelection().valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                bAPI.setLanguage(t1);
            }
        });
        vis.getPaletteButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HBox secondaryLayout = new HBox();
                Scene secondScene = new Scene(secondaryLayout, 250, 500);

                HBox temp = new HBox();
                temp = colors.createScene(temp);
                secondaryLayout.getChildren().addAll(temp);

                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Palette Viewer");
                newWindow.setScene(secondScene);

                // Set position of second window, related to primary window.
                newWindow.setX(primaryStage.getX() + 200);
                newWindow.setY(primaryStage.getY() + 100);

                newWindow.show();
            }
        });
        vis.getHelpButton().setOnAction(new EventHandler<ActionEvent>() {
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

        //CHOOSE COMMAND FILE NOT WORKING RN
        vis.getFileButton().setOnAction(event -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                for(Turtle turtle:t) {
                    if (turtle.isActive()) {
                        bAPI.runFile(file, turtle);
                    }
                }
            }
        });
    }

    public Visualizer getVisualizer(){
        return vis;
    }
}
