package slogo.configuration;

public interface TurtleInterface {
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

    //not implemented yet
    int clearScreen();

}
