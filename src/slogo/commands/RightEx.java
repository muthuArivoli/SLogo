package slogo.commands;

import slogo.Turtle;

import java.util.ArrayList;

public class RightEx extends Executable {
    private Executable d;
    public RightEx(){
        setParametersAmounts(1);
    }
    @Override
    public int runCommands(Turtle t) {
        return t.left(d.runCommands(t));
    }
    @Override
    public void setMyParameters(ArrayList<Executable> parameters) {
        d=parameters.get(0);
    }
}
