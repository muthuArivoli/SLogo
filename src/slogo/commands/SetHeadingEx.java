package slogo.commands;

import slogo.Turtle;

import java.util.ArrayList;

public class SetHeadingEx extends Executable {
    private Executable d;
    public SetHeadingEx(){
        setParametersAmounts(1);
    }
    @Override
    public int runCommands(Turtle t) {
        return t.setHeading(d.runCommands(t));
    }
    @Override
    public void setMyParameters(ArrayList<Executable> parameters) {
        d=parameters.get(0);
    }
}
