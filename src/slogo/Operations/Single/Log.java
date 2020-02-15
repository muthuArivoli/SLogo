package slogo.Operations.Single;

public class Log extends SOperation {

    @Override
    public int getResult(int v1) {
        return (int) Math.log(v1);
    }
}
