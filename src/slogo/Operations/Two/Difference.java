package slogo.Operations.Two;

import java.util.List;

public class Difference extends TOperation{
    @Override
    public int getResult(List<Integer> inputs) {
        return inputs.get(0)-inputs.get(1);
    }
}
