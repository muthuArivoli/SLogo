package slogo.commands;

import slogo.Turtle;
import slogo.Variables.CVariable;

import java.util.ArrayList;

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
    public void setMyParameters(ArrayList<Executable> parameters) {
        setTo=parameters.get(0);
    }
}
