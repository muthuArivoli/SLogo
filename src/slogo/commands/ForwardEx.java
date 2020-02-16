package slogo.commands;

import slogo.Turtle;

import java.util.ArrayList;

public class ForwardEx extends Executable {
    private Executable d;
    public ForwardEx(){
        setParametersAmounts(1);
    }
    @Override
    public int runCommands(Turtle t) {
        return t.forward(d.runCommands(t));
    }

    @Override
    public void setMyParameters(ArrayList<Executable> parameters) {
        d=parameters.get(0);
    }
}
