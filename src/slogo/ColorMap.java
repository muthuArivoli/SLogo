package slogo;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Collection;
import java.util.HashMap;

public class ColorMap {
    private static final String INDEX = "Index:";
    private static final String WEB_VALUE = "Web Value:";
    private static final String COLOR = "Color:";
    private static final int BASIC_SPACING = 10;
    private static final int COLOR_SPACING = 12;
    private static final Insets BASIC_PADDING = new Insets(BASIC_SPACING, BASIC_SPACING,
            BASIC_SPACING, BASIC_SPACING);

    private HashMap<Integer, Color> myCMap;

    private HBox displayPallet;

    public ColorMap(){
        myCMap = new HashMap<>();
        myCMap.put(1, Color.BLACK);
        myCMap.put(2, Color.WHITE);
        myCMap.put(3, Color.RED);
        myCMap.put(4, Color.BLUE);
        myCMap.put(5, Color.GREEN);
        myCMap.put(6, Color.YELLOW);
        myCMap.put(7, Color.ORANGE);
        myCMap.put(8, Color.PURPLE);
        displayPallet=new HBox();
        setDisplayPallet();
    }
    public Color getColor(int index){
        return myCMap.get(index);
    }

    public void setPallet(int index, int r, int g, int b){
        if(!myCMap.containsKey(index)){
            //ERROR
            System.out.println("outside of palette indexes");
            return;
        }
        Color newC= Color.rgb(r,g,b);
        myCMap.put(index, newC);
        setDisplayPallet();
    }

    private void setDisplayPallet() {
        displayPallet.getChildren().clear();
        VBox indexCol = new VBox(BASIC_SPACING);
        indexCol.setPadding(new Insets(BASIC_SPACING, BASIC_SPACING, BASIC_SPACING,30));
        VBox stringCol = new VBox(5);
        stringCol.setPadding(BASIC_PADDING);
        VBox colorCol = new VBox(BASIC_SPACING);
        colorCol.setPadding(BASIC_PADDING);
        Label in = new Label(INDEX);
        Label s = new Label(WEB_VALUE);
        Label c = new Label(COLOR);
        indexCol.getChildren().add(in);
        stringCol.getChildren().add(s);
        colorCol.getChildren().add(c);
        VBox indexCol2 = new VBox(BASIC_SPACING);
        VBox stringCol2 = new VBox();
        VBox colorCol2 = new VBox(COLOR_SPACING);
        for (int i:myCMap.keySet()) {
            Label num = new Label(Integer.toString(i));
            TextField col = new TextField(getColor(i).toString().substring(2, 8));
            col.setEditable(false);
            col.setMaxWidth(100);
            Rectangle r = new Rectangle(15, 15, getColor(i));

            indexCol2.getChildren().add(num);
            stringCol2.getChildren().add(col);
            colorCol2.getChildren().add(r);
        }
        indexCol.getChildren().add(indexCol2);
        stringCol.getChildren().add(stringCol2);
        colorCol.getChildren().add(colorCol2);

        displayPallet.getChildren().addAll(indexCol, colorCol, stringCol);
    }
    public HBox getDisplayPallet(){
        return displayPallet;
    }
}
