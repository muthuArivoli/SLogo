package slogo.Operations.Two;

import java.util.List;

public class Pow extends TOperation {
    @Override
    public int getResult(List<Integer> inputs) {
        return (int) Math.pow(inputs.get(0),inputs.get(1));
    }
}
