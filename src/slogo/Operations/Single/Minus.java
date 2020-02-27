package slogo.Operations.Single;

import java.util.List;

public class Minus extends SOperation {
    @Override
    public int getResult(List<Integer> inputs) {
        return -1*inputs.get(0);
    }
}
