package slogo.Visualizer;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

    public HBox createScene(HBox input) {
        VBox indexCol = new VBox(5);
        indexCol.setPadding(new Insets(10,10,10,30));
        VBox stringCol = new VBox(5);
        stringCol.setPadding(new Insets(10,10,10,10));
        VBox colorCol = new VBox(6.5);
        colorCol.setPadding(new Insets(10,10,10,10));
        Label in = new Label("Index:");
        Label s = new Label("String Value:");
        Label c = new Label("Color:");
        indexCol.getChildren().add(in);
        stringCol.getChildren().add(s);
        colorCol.getChildren().add(c);
        for (int i = 0; i < colorMap.size(); i++) {
            Label num = new Label(Integer.toString(i));
            Label col = new Label(colorMap.get(i).toString());
            Rectangle r = new Rectangle(15, 15, colorMap.get(i));

            indexCol.getChildren().add(num);
            stringCol.getChildren().add(col);
            colorCol.getChildren().add(r);
        }
        input.getChildren().addAll(indexCol, colorCol, stringCol);
        return input;
    }
}
