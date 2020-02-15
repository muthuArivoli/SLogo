package slogo.Operations.Single;

import java.util.Random;

public class RandOp extends SOperation {
    @Override
    public int getResult(int v1) {
        return new Random().nextInt(v1);
    }
}
