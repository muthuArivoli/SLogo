package slogo;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import slogo.Variables.CVariable;
import slogo.Visualizer.Visualizer;
import slogo.commands.Executable;
import slogo.commands.ForEx;
import slogo.commands.ForwardEx;
import slogo.commands.HideTurtleEx;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Feel free to completely change this code or delete it entirely. 
 */
public class Main extends Application {
    /**
     * Start of the program.
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
        ImageView tuti = resizeImage(new Image("turtle.png"));

        Turtle t = new Turtle(tuti);

        Visualizer vis = new Visualizer(tuti);
        primaryStage.setScene(vis.getScene());
        primaryStage.show();
        t.forward(300);
    }
    private ImageView resizeImage(Image input) {
        ImageView result = new ImageView();
        result.setImage(input);
        result.setFitWidth(30);
        result.setPreserveRatio(true);
        result.setSmooth(true);
        result.setCache(true);
        return result;
    }

}
