package slogo.Operations.Single;

import java.util.ArrayList;
import java.util.Random;

public class RandOp extends SOperation {
    @Override
    public int getResult(ArrayList<Integer> inputs) {
        return new Random().nextInt(inputs.get(0));
    }
}
