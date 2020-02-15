package slogo.Operations.Single;

public class Tan extends SOperation {
    @Override
    public int getResult(int v1) {
        return (int) Math.tan(Math.toRadians(v1));
    }
}
