package slogo.commands;

import slogo.Turtle;

import java.util.List;

public class RightEx extends Executable {
    private Executable d;
    public RightEx(){
        setParametersAmounts(1);
    }
    @Override
    public int runCommands(Turtle t) {
        return t.right(d.runCommands(t));
    }
    @Override
    public void setMyParameters(List<Executable> parameters) {
        d=parameters.get(0);
    }
}
