package slogo.Operations.Single;

import java.util.ArrayList;

public class Not extends SOperation {

    @Override
    public int getResult(ArrayList<Integer> inputs) {
        return (inputs.get(0)==0)? 1:0;
    }
}
