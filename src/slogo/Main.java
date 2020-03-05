package slogo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import slogo.Visualizer.Visualizer;
import slogo.Visualizer.paletteMap;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Feel free to completely change this code or delete it entirely. 
 */
public class Main extends Application {
    /**
     * Start of the program.
     *

     */

    public static Visualizer vis;
    public static paletteMap pMap;
    public static void main (String[] args) {
        launch(args);


//
//        Parser p=new Parser();
//        Turtle t=new Turtle();
//        File file = null;
//        Scanner input = new Scanner(System.in);
//
//        System.out.print("1. dash\n2. face\n3. flower\n4. house\n5. poly_fun\n6. random_range\n7. regularShape\n8. square\n\nInsert int: ");
//        int ans = input.nextInt();
//        switch (ans){
//            case 1:
//                file = new File("data/examples/procedures_with_parameters/dash.logo");
//                break;
//            case 2:
//                file = new File("data/examples/procedures_with_parameters/face.logo");
//                break;
//            case 3:
//                file = new File("data/examples/procedures_with_parameters/flower.logo");
//                break;
//            case 4:
//                file = new File("data/examples/procedures_with_parameters/house.logo");
//                break;
//            case 5:
//                file = new File("data/examples/procedures_with_parameters/poly_fun.logo");
//                break;
//            case 6:
//                file = new File("data/examples/procedures_with_parameters/random_range.logo");
//                break;
//            case 7:
//                file = new File("data/examples/procedures_with_parameters/regularShape.logo");
//                break;
//            case 8:
//                file = new File("data/examples/procedures_with_parameters/square.logo");
//                break;
//        }
//
//        Scanner sc = null;
//
//        try {
//            sc = new Scanner(file);
//        } catch (FileNotFoundException e) {
//            System.out.println("the file was not found");
//        }
//
//        Executable circle = p.parse(sc);
//
//        sc.close();
//
//        circle.runCommands(t);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        pMap = new paletteMap();
        vis = new Visualizer();
        primaryStage.setScene(vis.getScene());
        primaryStage.setResizable(false);
        primaryStage.show();
        final FileChooser fileChooser = new FileChooser();

        List<Turtle> t = new ArrayList<Turtle>();
        t.add(vis.addTurtle(t.size()));

        BackEndAPI bAPI=new BackEndAPI();
        vis.getRunButton().setOnAction(event -> {
            try {
                for(Turtle turtle:t) {
                    bAPI.buildAndRun(vis.getScript(), turtle);
                }
                vis.updateHistory(vis.getScript());
            }
            catch(IncorrectCommandException ice){
                vis.alertCreator("Build Failed",ice.getMessage());
            }
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
                Button toggle = new Button("Pen Up");
                toggle.setMinWidth(130);
                AtomicInteger toggled = new AtomicInteger(1);
                toggle.setOnAction(event2 -> {
                    for (Turtle turtle : t)  {
                        if (toggled.get() == 1) {
                            turtle.penUp();
                            toggle.setText("Pen Down");
                            toggled.addAndGet(-1);
                        }
                        else {
                            turtle.penDown();
                            toggle.setText("Pen Up");
                            toggled.addAndGet(1);
                        }

                    }
                });
                ColorPicker picker = new ColorPicker();
                picker.setOnAction(event3 -> {
                    for (Turtle turtle : t)  {
                        turtle.updatePenColor(picker.getValue());
                    }
                });
                temp.getChildren().addAll(slider1, toggle, picker);
                secondaryLayout.getChildren().addAll(temp);

                // New window (Stage)
                Stage newWindow = new Stage();
                newWindow.setTitle("Pen Editor");
                newWindow.setScene(secondScene);

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
        vis.getPaletteButton().setOnAction(new EventHandler<ActionEvent>() {
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

        //CHOOSE FILE NOT WORKING RN
        vis.getFileButton().setOnAction(event -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                for(Turtle turtle:t) {
                    bAPI.runFile(file, turtle);
                }
            }
        });
    }


}
