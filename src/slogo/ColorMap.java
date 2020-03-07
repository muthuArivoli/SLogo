package slogo;

import java.util.HashMap;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import slogo.configuration.Property;

public class ColorMap {

    private static final int HEX_START_INDEX = 2;
    private static final int HEX_END_INDEX = 8;
    private static final int RECT_SIZE = 15;
    private static final int COL_WIDTH = 100;
    private Property prop = new Property();
    private final String INDEX = prop.getPropValues("colmap1");
    private final String WEB_VALUE = prop.getPropValues("colmap2");
    private final String COLOR = prop.getPropValues("colmap3");
    private static final int BASIC_SPACING = 10;
    private static final int COLOR_SPACING = 12;
    private static final Insets BASIC_PADDING = new Insets(BASIC_SPACING, BASIC_SPACING,
            BASIC_SPACING, BASIC_SPACING);

    private HashMap<Integer, Color> myCMap;

    private HBox displayPallet;

    ColorMap(){
        myCMap = new HashMap<>();
        Color[] cArray = new Color[]{Color.BLACK, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN,
            Color.YELLOW, Color.ORANGE, Color.PURPLE};
        for (int i = 1; i <= cArray.length; i++) {
            myCMap.put(i, cArray[i-1]);
        }
        displayPallet=new HBox();
        setDisplayPallet();
    }
    Color getColor(int index){
        return myCMap.get(index);
    }

    void setPallet(int index, int r, int g, int b){
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
            TextField col = new TextField(getColor(i).toString().substring(HEX_START_INDEX,
                HEX_END_INDEX));
            col.setEditable(false);
            col.setMaxWidth(COL_WIDTH);
            Rectangle r = new Rectangle(RECT_SIZE, RECT_SIZE, getColor(i));

            indexCol2.getChildren().add(num);
            stringCol2.getChildren().add(col);
            colorCol2.getChildren().add(r);
        }
        indexCol.getChildren().add(indexCol2);
        stringCol.getChildren().add(stringCol2);
        colorCol.getChildren().add(colorCol2);

        displayPallet.getChildren().addAll(indexCol, colorCol, stringCol);
    }
    HBox getDisplayPallet(){
        return displayPallet;
    }
}
