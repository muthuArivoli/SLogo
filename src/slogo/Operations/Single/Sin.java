package slogo.Operations.Single;

import java.util.ArrayList;

public class Sin extends SOperation {
    @Override
    public int getResult(ArrayList<Integer> inputs) {
        return (int) Math.sin(Math.toRadians(inputs.get(0)));
    }
}
