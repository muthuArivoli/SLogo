package slogo.Operations.Single;

import java.util.ArrayList;

public class ATan extends SOperation {
    @Override
    public int getResult(ArrayList<Integer> inputs) {
        return (int) Math.toDegrees(Math.atan(inputs.get(0)));
    }
}
