package slogo.commands;

import slogo.Turtle;

import java.util.ArrayList;

public class TowardsEx extends Executable {
    private Executable d1;
    private Executable d2;
    public TowardsEx(){
        setParametersAmounts(2);
    }
    @Override
    public int runCommands(Turtle t) {
        return t.towards(d1.runCommands(t), d2.runCommands(t));
    }
    @Override
    public void setMyParameters(ArrayList<Executable> parameters) {
        d1=parameters.get(0);
        d2=parameters.get(1);
    }
}
