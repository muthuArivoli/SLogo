package slogo.Operations.Two;

import slogo.Operations.Single.SOperation;

import java.util.ArrayList;

public class Less extends TOperation {
    @Override
    public int getResult(ArrayList<Integer> inputs) {
        return inputs.get(0)<inputs.get(1)? 1:0;
    }
}
