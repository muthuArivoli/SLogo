package slogo.Operations.Two;

import java.util.ArrayList;

public class Or extends TOperation {
    @Override
    public int getResult(ArrayList<Integer> inputs) {
        return (inputs.get(0)!=0)||(inputs.get(1)!=0)? 1:0;
    }
}
