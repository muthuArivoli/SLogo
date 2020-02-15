package slogo.Operations.Single;

public class ATan extends SOperation {
    @Override
    public int getResult(int v1) {
        return (int) Math.toDegrees(Math.atan(v1));
    }
}
