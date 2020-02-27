package slogo.Operations.Single;

import java.util.List;

public class Log extends SOperation {
    @Override
    public int getResult(List<Integer> inputs) {
        return (int) Math.log(inputs.get(0));
    }
}
