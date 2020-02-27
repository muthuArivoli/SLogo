package slogo.Operations.Single;

import java.util.List;

public class Tan extends SOperation {
    @Override
    public int getResult(List<Integer> inputs) {
        return (int) Math.tan(Math.toRadians(inputs.get(0)));
    }
}
