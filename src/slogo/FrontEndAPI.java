package slogo;

import javafx.scene.Group;
import slogo.commands.Executable;
import slogo.configuration.TurtleInterface;
import java.util.ArrayList;
import java.util.HashMap;

public class FrontEndAPI implements TurtleInterface {
    private HashMap<Integer, Turtle> myTurtles;
    private ArrayList<Integer> currentTurtles;
    private Group myVisuals;
    private int width;
    private int height;

    public FrontEndAPI(Group visuals, int width, int height, int numTurtles){
        this.myTurtles = new HashMap<>();
        this.myVisuals=visuals;
        this.width=width;
        this.height=height;
        for(int i =0 ; i< numTurtles;i++){
            addTurtle(i+1);
        }
    }

    public int turtles(){
        return myTurtles.size();
    }

    public int id(){
        int ret=0;
        for(int i:currentTurtles){
                ret = i;
        }
        return ret;
    }

    public ArrayList<Integer> askWith(Executable e){
        ArrayList<Integer> old = currentTurtles;
        currentTurtles =new ArrayList<>();
        for(int i:myTurtles.keySet()){
            if(e.runCommands(myTurtles.get(i))==1){
                currentTurtles.add(i);
            }
        }
        return old;
    }

    public ArrayList<Integer> ask(ArrayList<Integer> turtles){
        ArrayList<Integer> old = currentTurtles;
        currentTurtles = turtles;
        return old;
    }

    public int tell(ArrayList<Integer> turtles){
        int ret=0;
        for(int i:turtles){
            if(!myTurtles.containsKey(i)){
                addTurtle(i);
            }
            ret=i;
        }
        currentTurtles=turtles;
        return ret;
    }

    @Override
    public int getXCor() {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).getXCor();
        }
        return ret;
    }

    @Override
    public int getYCor() {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).getYCor();
        }
        return ret;
    }

    @Override
    public int getHeading() {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).getHeading();
        }
        return ret;
    }

    @Override
    public int getPenDown() {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).getPenDown();
        }
        return ret;
    }

    @Override
    public int getShowing() {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).getShowing();
        }
        return ret;
    }

    @Override
    public int forward(int pixels) {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).forward(pixels);
        }
        return ret;
    }

    @Override
    public int back(int pixels) {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).back(pixels);
        }
        return ret;
    }

    @Override
    public int right(int degrees) {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).right(degrees);
        }
        return ret;
    }

    @Override
    public int left(int degrees) {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).left(degrees);
        }
        return ret;
    }

    @Override
    public int setHeading(int degrees) {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).setHeading(degrees);
        }
        return ret;
    }

    @Override
    public int towards(int x, int y) {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).towards(x, y);
        }
        return ret;
    }

    @Override
    public int setXY(int x, int y) {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).setXY(x, y);
        }
        return ret;
    }

    @Override
    public int penDown() {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).penDown();
        }
        return ret;
    }

    @Override
    public int penUp() {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).penUp();
        }
        return ret;
    }

    @Override
    public int showTurtle() {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).showTurtle();
        }
        return ret;
    }

    @Override
    public int hideTurtle() {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).hideTurtle();
        }
        return ret;
    }

    @Override
    public int home() {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).home();
        }
        return ret;
    }

    @Override
    public int clearScreen() {
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).clearScreen();
        }
        return ret;
    }

    public void addTurtle(int id){
        Turtle newT=new Turtle(width,height,1);
        myTurtles.put(id, newT);
        myVisuals.getChildren().addAll(newT.getTurtleGroup());
    }
}
