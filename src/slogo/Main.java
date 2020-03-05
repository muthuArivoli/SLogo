package slogo;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import slogo.Visualizer.Visualizer;
import javafx.scene.control.Label;
import slogo.Visualizer.paletteMap;
import slogo.commands.Executable;
import slogo.commands.ForEx;
import slogo.commands.ForwardEx;
import slogo.commands.HideTurtleEx;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to completely change this code or delete it entirely. 
 */
public class Main extends Application {
    /**
     * Start of the program.
     *

     */
    private List<Workspace> workspaces;
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

    public void start(Stage primaryStage) {

        List<Workspace> workspaces = new ArrayList<>();
        workspaces.add(new Workspace(primaryStage));


    }


}
