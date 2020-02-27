package slogo.Operations.Single;

import java.util.List;

public class Sin extends SOperation {
    @Override
    public int getResult(List<Integer> inputs) {
        return (int) Math.sin(Math.toRadians(inputs.get(0)));
    }
}
