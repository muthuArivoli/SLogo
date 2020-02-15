package slogo.Operations.Two;

import slogo.Operations.Single.SOperation;

public class Less extends TOperation {
    @Override
    public int getResult(int v1, int v2) {
        return v1<v2? 1:0;
    }
}
