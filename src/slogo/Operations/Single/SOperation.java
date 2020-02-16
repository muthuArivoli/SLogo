package slogo.Operations.Single;

import slogo.Operations.Operation;

public abstract class SOperation extends Operation {
    @Override
    public int getNumInputs(){
        return 1;
    }
}
