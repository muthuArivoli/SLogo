package slogo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import slogo.configuration.TurtleInterface;

public class Turtle implements TurtleInterface {
    public static final int EAST_FACING_DEGREES = 90;
    public static final int WEST_FACING_DEGREES = 270;
    private int xCor;
    private int yCor;
    private int heading;
    private boolean penDown;
    private boolean showing;
    private ImageView turtleImage;
    public Turtle(ImageView turtleImage){
        this.xCor=0;
        this.yCor=0;
        this.heading=0;
        this.penDown=true;
        this.showing=true;
        this.turtleImage = turtleImage;
    }
    public int getXCor(){
        return xCor;
    }
    public int getYCor(){
        return yCor;
    }
    public int getHeading(){
        return heading;
    }
    public int getPenDown(){
        return penDown ? 1 : 0;
    }
    public int getShowing(){
        return showing ? 1 : 0;
    }
    public int forward(int pixels){
        xCor+=Math.sin(Math.toRadians(heading))*pixels;
        yCor+=Math.cos(Math.toRadians(heading))*pixels;
        System.out.println("Forward: "+pixels);
        moveTurtleImage();
        return pixels;
    }



    public int back(int pixels){
        forward(-pixels);
        return pixels;
    }
    public int right(int degrees){
        heading=correctDegrees(heading+degrees);
        System.out.println("Right: "+degrees);
        return degrees;
    }
    public int left(int degrees){
        heading=correctDegrees(heading-degrees);
        System.out.println("Left: "+degrees);
        return degrees;
    }
    public int setHeading(int degrees){
        int change = Math.abs(heading-correctDegrees(degrees));
        heading=degrees;
        System.out.println("Set Heading: "+degrees);
        return change;
    }
    public int towards(int x, int y){
        int newHeading;
        if(y == yCor){
            if(x>0){
                newHeading= EAST_FACING_DEGREES;
            }
            else if(x<0){
                newHeading= WEST_FACING_DEGREES;
            }
            else{
                newHeading= heading;
            }
        }
        else {
            double dy=y-yCor;
            double dx=x-xCor;
            double rad = Math.atan(dx/dy);
            newHeading=(int) Math.toDegrees(rad);
        }
        return setHeading(newHeading);
    }
    public int setXY(int x, int y){
        double dist = pythagorean(x-xCor,y-yCor);
        xCor=x;
        yCor=y;
        System.out.println("Set X: "+x+", Y: "+y);
        return (int) dist;
    }

    public int penDown(){
        penDown=true;
        System.out.println("Pen Down");
        return 1;
    }
    public int penUp(){
        penDown=false;
        System.out.println("Pen Up");
        return 0;
    }
    public int showTurtle(){
        showing=true;
        System.out.println("Show Turtle");
        return 1;
    }
    public int hideTurtle(){
        showing=false;
        System.out.println("Hide Turtle");
        return 0;
    }
    public int home(){
        return setXY(0,0);
    }

    public int clearScreen() {
        return 0;
    }

    private double pythagorean(double a, double b){
        double cSquared= (a*a)+(b*b);
        return Math.sqrt(cSquared);
    }

    private int correctDegrees(int degrees){
        while(degrees<0){
            degrees+=360;
        }
        while(degrees>360){
            degrees-=360;
        }

        return degrees;
    }

    // Image methods below --- :)
    private void moveTurtleImage() {
        turtleImage.setX(xCor);
        turtleImage.setY(yCor);
        System.out.println(yCor);
    }


}
