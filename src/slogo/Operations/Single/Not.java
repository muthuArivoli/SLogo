package slogo.Operations.Single;

public class Not extends SOperation {

    @Override
    public int getResult(int v1) {
        return (v1==0)? 1:0;
    }
}
