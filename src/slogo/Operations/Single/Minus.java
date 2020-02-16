package slogo.Operations.Single;

import java.util.ArrayList;

public class Minus extends SOperation {
    @Override
    public int getResult(ArrayList<Integer> inputs) {
        return -1*inputs.get(0);
    }
}
