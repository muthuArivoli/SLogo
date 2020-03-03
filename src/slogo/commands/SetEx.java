package slogo.commands;

import slogo.Turtle;

import java.util.List;

public class SetEx extends VExecutable {
    private Executable setTo;
    public SetEx(){
        setParametersAmounts(1);
    }
    @Override
    public int runCommands(Turtle t) {
        return myVariable.setData(setTo.runCommands(t));
    }
    @Override
    public void setMyParameters(List<Executable> parameters) {
        setTo=parameters.get(0);
    }
}
