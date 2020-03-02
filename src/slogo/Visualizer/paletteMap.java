package slogo.Visualizer;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.HashMap;

public class paletteMap {
    HashMap<Integer, Color> colorMap;

    public paletteMap() {
        colorMap = new HashMap<>();
        colorMap.put(0, Color.RED);
        colorMap.put(1, Color.BLUE);
        colorMap.put(2, Color.GREEN);
        colorMap.put(3, Color.YELLOW);
        colorMap.put(4, Color.ORANGE);
        colorMap.put(5, Color.PURPLE);
    }

    public void add(int index, Color value) {colorMap.put(index, value);}
    public void remove(int index) {colorMap.remove(index);}
    public HashMap<Integer, Color> getColorMap() {return colorMap;}

    public HBox createScene(int index, Color value) {
        HBox paletteHolder = new HBox();
        Label num = new Label(Integer.toString(index) + "      ");
        Label col = new Label(value.toString() + "      ");
        Rectangle r = new Rectangle(15, 15, value);
        paletteHolder.getChildren().addAll(num, col, r);
        return paletteHolder;
    }
}
