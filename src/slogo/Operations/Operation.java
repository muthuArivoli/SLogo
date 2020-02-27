package slogo.Operations;

import java.util.List;

public abstract class Operation {
    public abstract int getResult(List<Integer> inputs);
    public abstract int getNumInputs();
}
