package slogo.commands;

import slogo.Turtle;

import java.util.List;

public class SetXYEx extends Executable {
    private Executable d1;
    private Executable d2;
    public SetXYEx(){
        setParametersAmounts(2);
    }
    @Override
    public int runCommands(Turtle t) {
        return t.setXY(d1.runCommands(t), d2.runCommands(t));
    }
    @Override
    public void setMyParameters(List<Executable> parameters) {
        d1=parameters.get(0);
        d2=parameters.get(1);
    }
}
