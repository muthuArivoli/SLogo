package slogo.Operations.Single;

import java.util.ArrayList;

public class Log extends SOperation {
    @Override
    public int getResult(ArrayList<Integer> inputs) {
        return (int) Math.log(inputs.get(0));
    }
}
