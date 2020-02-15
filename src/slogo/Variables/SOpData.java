package slogo.Variables;

import slogo.Operations.Single.SOperation;

public class SOpData extends Data{
    private SOperation operation;
    private Data expr1;
    public SOpData(SOperation operation,Data d1){
        this.operation=operation;
        this.expr1=d1;
    }

    @Override
    public int getData() {
        return operation.getResult(expr1.getData());
    }
}
