package slogo.configuration;

import java.util.ArrayList;
import slogo.commands.Executable;

public interface CommandInterface {
    public static final int EAST_FACING_DEGREES = 90;
    public static final int WEST_FACING_DEGREES = 270;


    int getXCor();
    int getYCor();
    int getHeading();
    int getPenDown();
    int getShowing();
    int forward(int pixels);
    int back(int pixels);
    int right(int degrees);
    int left(int degrees);
    int setHeading(int degrees);
    int towards(int x, int y);
    int setXY(int x, int y);
    int penDown();
    int penUp();
    int showTurtle();
    int hideTurtle();
    int home();

    int setBackground(int index);
    int setPenColor(int index);
    int setShape(int index);
    int setPallet(int index, int r, int g, int b);
    int setPenSize(int pixels);
    int getPenColor();
    int getShape();
    ArrayList<Integer> ask(ArrayList<Integer> turtles);
    ArrayList<Integer> askWith(Executable e);
    int tell(ArrayList<Integer> turtles);
    int id();
    int turtles();



    //not implemented yet
    int clearScreen();

}
