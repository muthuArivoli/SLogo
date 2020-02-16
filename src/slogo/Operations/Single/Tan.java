package slogo.Operations.Single;

import java.util.ArrayList;

public class Tan extends SOperation {
    @Override
    public int getResult(ArrayList<Integer> inputs) {
        return (int) Math.tan(Math.toRadians(inputs.get(0)));
    }
}
