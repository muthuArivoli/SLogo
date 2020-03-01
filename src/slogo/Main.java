package slogo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import slogo.Visualizer.Visualizer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Feel free to completely change this code or delete it entirely. 
 */
public class Main extends Application {
    /**
     * Start of the program.
     *

     */


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
        Visualizer vis = new Visualizer();
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
        vis.getLangSelection().valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue ov, String t, String t1) {
                bAPI.setLanguage(t1);
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
