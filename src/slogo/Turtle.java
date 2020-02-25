package slogo;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import slogo.configuration.TurtleInterface;

public class Turtle implements TurtleInterface {
    public static final int EAST_FACING_DEGREES = 90;
    public static final int WEST_FACING_DEGREES = 270;
    public static final int SCALE_DOWN = 1;
    private int width;
    private int height;
    private int xCor;
    private int yCor;
    private int heading;
    private boolean penDown;
    private boolean showing;
    private ImageView turtleImage;
    private Group myLines;
    private Paint currentColor;

    public Turtle(int width, int height){
        this.xCor=0;
        this.yCor=0;
        this.heading=0;
        this.penDown=true;
        this.showing=true;
        this.turtleImage = resizeImage(new Image("turtle.png"));
        this.myLines = new Group();
        this.width=width;
        this.height=height;
        this.currentColor= Color.BLACK;
        updateTurtle();
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
        int oldX=xCor;
        int oldY=yCor;
        xCor+=Math.sin(Math.toRadians(heading))*pixels;
        yCor+=Math.cos(Math.toRadians(heading))*pixels;
        System.out.println("Forward: "+pixels);
        moveTurtleImage();
        drawLine(oldX,oldY);
        return pixels;
    }



    public int back(int pixels){
        forward(-pixels);
        return pixels;
    }
    public int right(int degrees){
        heading=correctDegrees(heading+degrees);
        rotateTurtleImage();
        System.out.println("Right: "+degrees);
        return degrees;
    }
    public int left(int degrees){
        heading=correctDegrees(heading-degrees);
        rotateTurtleImage();
        System.out.println("Left: "+degrees);
        return degrees;
    }
    public int setHeading(int degrees){
        int change = Math.abs(heading-correctDegrees(degrees));
        heading=degrees;
        rotateTurtleImage();
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
        int oldX=xCor;
        int oldY=yCor;
        xCor=x;
        yCor=y;
        drawLine(oldX,oldY);
        moveTurtleImage();
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
        turtleImage.setDisable(false);
        System.out.println("Show Turtle");
        return 1;
    }
    public int hideTurtle(){
        showing=false;
        turtleImage.setDisable(true);
        System.out.println("Hide Turtle");
        return 0;
    }
    public int home(){
        return setXY(0,0);
    }

    public int clearScreen() {
        myLines.getChildren().removeAll();
        return home();
    }
    public void setPenColor(Paint color){
        currentColor=color;
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

    public Group getTurtleGroup(){
        Group ret=new Group();
        ret.getChildren().addAll(turtleImage, myLines);
        return ret;
    }
    private void updateTurtle(){
        moveTurtleImage();
        rotateTurtleImage();
    }

    // Image methods below --- :)
    private void moveTurtleImage() {
        turtleImage.setX(adjustedX(xCor)-turtleImage.getFitWidth()/2);
        turtleImage.setY(adjustedY(yCor)-turtleImage.getFitWidth()/2);
    }
    private void rotateTurtleImage(){
        turtleImage.setRotate(heading);
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

    private void drawLine(int sX, int sY){
        if(penDown){
            Line line = new Line(adjustedX(sX), adjustedY(sY), adjustedX(xCor), adjustedY(yCor));
            line.setStroke(currentColor);
            myLines.getChildren().addAll(line);
        }
    }
    private double adjustedX(int x){
        return (width / 2) + (x/SCALE_DOWN);
    }
    private double adjustedY(int y){
        return (height / 2) - (y/SCALE_DOWN);
    }


}
