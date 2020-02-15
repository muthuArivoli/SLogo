package slogo.Variables;

import slogo.Operations.Two.TOperation;

public class TOpData extends Data {
    private TOperation operation;
    private Data expr1;
    private Data expr2;
    public TOpData(TOperation operation, Data d1, Data d2){
        this.operation=operation;
        expr1=d1;
        expr2=d2;
    }

    @Override
    public int getData() {
        return operation.getResult(expr1.getData(), expr2.getData());
    }
}
