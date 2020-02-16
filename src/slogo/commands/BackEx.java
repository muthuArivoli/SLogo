package slogo.commands;

import slogo.Turtle;

import java.util.ArrayList;

public class BackEx extends Executable {
    private Executable d;
    public BackEx(){
        setParametersAmounts(1);
    }
    @Override
    public int runCommands(Turtle t) {
        return t.back(d.runCommands(t));
    }

    @Override
    public void setMyParameters(ArrayList<Executable> parameters) {
        d=parameters.get(0);
    }
}
