package slogo.Operations.Single;

public class Cos extends SOperation {
    @Override
    public int getResult(int v1) {
        return (int) Math.cos(Math.toRadians(v1));
    }
}
