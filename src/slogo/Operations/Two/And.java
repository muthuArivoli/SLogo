package slogo.Operations.Two;

public class And extends TOperation {
    @Override
    public int getResult(int v1, int v2) {
        return (v1!=0)&&(v2!=0)? 1:0;
    }
}
