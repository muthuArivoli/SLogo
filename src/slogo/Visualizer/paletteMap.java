package slogo.Visualizer;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.HashMap;

public class paletteMap {

    private static final String INDEX = "Index:";
    private static final String WEB_VALUE = "Web Value:";
    private static final String COLOR = "Color:";
    private static final int BASIC_SPACING = 10;
    private static final Insets BASIC_PADDING = new Insets(BASIC_SPACING, BASIC_SPACING,
        BASIC_SPACING, BASIC_SPACING);
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
        VBox indexCol = new VBox(BASIC_SPACING);
        indexCol.setPadding(new Insets(BASIC_SPACING, BASIC_SPACING, BASIC_SPACING,30));
        VBox stringCol = new VBox(5);
        stringCol.setPadding(BASIC_PADDING);
        VBox colorCol = new VBox(BASIC_SPACING);
        colorCol.setPadding(BASIC_PADDING);
        VBox indexCol2 = new VBox(BASIC_SPACING);
        VBox stringCol2 = new VBox();
        VBox colorCol2 = new VBox(12);
        Label in = new Label(INDEX);
        Label s = new Label(WEB_VALUE);
        Label c = new Label(COLOR);
        indexCol.getChildren().add(in);
        stringCol.getChildren().add(s);
        colorCol.getChildren().add(c);
        for (int i = 0; i < colorMap.size(); i++) {
            Label num = new Label(Integer.toString(i));
            TextField col = new TextField(colorMap.get(i).toString().substring(2, 8));
            col.setEditable(false);
            col.setMaxWidth(100);
            Rectangle r = new Rectangle(15, 15, colorMap.get(i));

            indexCol2.getChildren().add(num);
            stringCol2.getChildren().add(col);
            colorCol2.getChildren().add(r);
        }
        indexCol.getChildren().add(indexCol2);
        stringCol.getChildren().add(stringCol2);
        colorCol.getChildren().add(colorCol2);
        input.getChildren().addAll(indexCol, colorCol, stringCol);
        return input;
    }
}
