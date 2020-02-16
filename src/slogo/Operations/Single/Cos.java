package slogo.Operations.Single;

import java.util.ArrayList;

public class Cos extends SOperation {
    @Override
    public int getResult(ArrayList<Integer> inputs) {
        return (int) Math.cos(Math.toRadians(inputs.get(0)));
    }
}
