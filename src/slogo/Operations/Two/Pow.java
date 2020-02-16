package slogo.Operations.Two;

import java.util.ArrayList;

public class Pow extends TOperation {
    @Override
    public int getResult(ArrayList<Integer> inputs) {
        return (int) Math.pow(inputs.get(0),inputs.get(1));
    }
}
