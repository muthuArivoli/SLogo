package slogo;

import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import slogo.Visualizer.DashboardView;
import slogo.Visualizer.HistoryView;
import slogo.Visualizer.TurtleView;
import slogo.Visualizer.Visualizer;
import slogo.commands.Executable;
import slogo.configuration.CommandInterface;
import java.util.ArrayList;
import java.util.HashMap;

public class FrontEndAPI implements CommandInterface {
    private HashMap<Integer, Turtle> myTurtles;
    private ArrayList<Integer> currentTurtles;
    private Group myVisuals;
    private int width;
    private int height;
    private ColorMap myPallet;
    private Color currentPenColor;
    private int currentPenColorIndex;
    private TurtleView myTurtleView;
    private DashboardView myDashboardView;

    public FrontEndAPI(TurtleView tv, DashboardView dv, int numTurtles, ArrayList<Integer> activeTurtles){
        this.myTurtleView=tv;
        this.myDashboardView = dv;
        this.myPallet =new ColorMap();
        this.myTurtles = new HashMap<>();
        this.myVisuals=new Group();
        this.myTurtleView.addGroup(myVisuals);

        this.width=tv.getWidth();
        this.height=tv.getHeight();
        setPenColor(1);
        this.currentTurtles = activeTurtles;
        for(int i =0 ; i< numTurtles;i++){
            addTurtle(i+1);
        }
    }

    @Override
    public int turtles(){
        return myTurtles.size();
    }

    @Override
    public int id(){
        int ret=0;
        for(int i:currentTurtles){
                ret = i;
        }
        return ret;
    }

    @Override
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

    @Override
    public ArrayList<Integer> ask(ArrayList<Integer> turtles){
        ArrayList<Integer> old = currentTurtles;
        currentTurtles = turtles;
        return old;
    }

    @Override
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
            if(myTurtles.get(i).isActive()) {
                ret = myTurtles.get(i).forward(pixels);
            }
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
        for(int i:currentTurtles) {
            if (myTurtles.get(i).isActive()) {
                ret = myTurtles.get(i).right(degrees);
            }
        }
        return ret;
    }

    @Override
    public int left(int degrees) {
        int ret=0;
        for(int i:currentTurtles) {
            if (myTurtles.get(i).isActive()) {
                ret = myTurtles.get(i).left(degrees);
            }
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
        for(int i:currentTurtles) {
            if (myTurtles.get(i).isActive()) {
                ret = myTurtles.get(i).towards(x, y);
            }
        }
        return ret;
    }

    @Override
    public int setXY(int x, int y) {
        int ret=0;
        for(int i:currentTurtles) {
            if (myTurtles.get(i).isActive()) {
                ret = myTurtles.get(i).setXY(x, y);
            }
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
    public int setBackground(int index) {
        myTurtleView.updateBackgroundColor(myPallet.getColor(index));
        return index;
    }

    @Override
    public int setPenColor(int index) {
        currentPenColor = myPallet.getColor(index);
        currentPenColorIndex = index;
        updatePenColor();
        return index;
    }

    @Override
    public int setShape(int index) {
        for(int i:currentTurtles){
            myTurtles.get(i).setImage(index);
        }
        return index;
    }

    @Override
    public int setPallet(int index, int r, int g, int b) {
        myPallet.setPallet(index, r, g, b);
        return index;
    }

    @Override
    public int setPenSize(int pixels) {
        for(int i:currentTurtles){
            myTurtles.get(i).setPenSize(pixels);
        }
        return pixels;
    }

    @Override
    public int getPenColor() {
        return currentPenColorIndex;
    }

    public Color getPenPaintColor(){
        return currentPenColor;
    }

    public void setSelectedPenColor(Color c){
        currentPenColor=c;
        updatePenColor();
    }

    @Override
    public int getShape() {
        int ret = 0;
        for(int i:currentTurtles){
        ret = myTurtles.get(i).getShape();
        }
        return ret;
    }

    @Override
    public int clearScreen() {
        int ret=0;
        for(int i:currentTurtles){
            ret = myTurtles.get(i).clearScreen();
        }
        return ret;
    }

    public void setBackgroundColorUsingXML(String newColor){
        myTurtleView.setBackgroundColorUsingXML(newColor);
    }

    public void setCurrentScriptUsingXML(String newCurrentScript){myDashboardView.setScript(newCurrentScript);};

    public void setPastScriptsUsingXML(HistoryView newPastScripts) {myDashboardView.setPastScript(newPastScripts);}

    public void addTurtle(int id){
        Turtle newT=new Turtle(width,height, currentPenColor,id);
        myTurtles.put(id, newT);
        myVisuals.getChildren().addAll(newT.getTurtleGroup());
    }

    public String getStringBackgroundColor(){
        return myTurtleView.getBackgroundColor();
    }

    public HBox getDisplayPalette(){
        return myPallet.getDisplayPallet();
    }

    public int getPenSize(){
        int ret=0;
        for(int i:currentTurtles){
            ret= myTurtles.get(i).getPenSize();
        }
        return ret;
    }

    private void updatePenColor(){
        for(Turtle t: myTurtles.values()){
            t.setPenColor(currentPenColor);
        }
    }
}
