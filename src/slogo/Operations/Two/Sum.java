package slogo.Operations.Two;

import java.util.ArrayList;

public class Sum extends TOperation {
    @Override
    public int getResult(ArrayList<Integer> inputs) {
        return inputs.get(0)+inputs.get(1);
    }
}