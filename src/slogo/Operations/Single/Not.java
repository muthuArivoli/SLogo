package slogo.Operations.Single;

import java.util.List;

public class Not extends SOperation {

    @Override
    public int getResult(List<Integer> inputs) {
        return (inputs.get(0)==0)? 1:0;
    }
}
