package slogo.Operations.Single;

import java.util.List;

public class Cos extends SOperation {
    @Override
    public int getResult(List<Integer> inputs) {
        return (int) Math.cos(Math.toRadians(inputs.get(0)));
    }
}
