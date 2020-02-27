package slogo.Operations.Single;

import java.util.List;
import java.util.Random;

public class RandOp extends SOperation {
    @Override
    public int getResult(List<Integer> inputs) {
        return new Random().nextInt(inputs.get(0));
    }
}
