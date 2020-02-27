package slogo.commands;

import slogo.Turtle;

import java.util.List;

public class ToEx extends Executable {
    private Executable d;
    public ToEx(){
        setParametersAmounts(1);
    }
    @Override
    public int runCommands(Turtle t) {
        return d.runCommands(t);
    }

    @Override
    public void setMyParameters(List<Executable> parameters) {
        d=parameters.get(0);
    }

    @Override
    public boolean isFunction(){
        return true;
    }
}
