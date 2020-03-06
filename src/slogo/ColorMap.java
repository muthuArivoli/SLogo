package slogo;

import javafx.scene.paint.Color;

import java.util.HashMap;

public class ColorMap {
    private HashMap<Integer, Color> myCMap;
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
    }
    public Color getColor(int index){
        return myCMap.get(index);
    }

    public void setPallet(int index, int r, int g, int b){
        Color newC= Color.rgb(r,g,b);
        myCMap.put(index, newC);
    }
}
