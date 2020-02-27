package slogo.Operations.Single;

import java.util.List;

public class ATan extends SOperation {
    @Override
    public int getResult(List<Integer> inputs) {
        return (int) Math.toDegrees(Math.atan(inputs.get(0)));
    }
}
