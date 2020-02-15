package slogo.Operations.Single;

public class Sin extends SOperation {
    @Override
    public int getResult(int v1) {
        return (int) Math.sin(Math.toRadians(v1));
    }
}
