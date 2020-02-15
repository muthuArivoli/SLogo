package slogo.Operations.Two;

public class Pow extends TOperation {
    @Override
    public int getResult(int v1, int v2) {
        return (int) Math.pow(v1, v2);
    }
}
