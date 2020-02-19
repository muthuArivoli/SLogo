package slogo.commands;

import slogo.Function;
import slogo.Turtle;

import java.util.ArrayList;

public class CommandEx extends Executable{
    private Function myFunction;
    private ArrayList<Executable> myInputs;

    public CommandEx(Function f){
        myFunction=f;
        setParametersAmounts(f.getParametersAmounts());
    }

    @Override
    public int runCommands(Turtle t) {
        myFunction.setParameters(myInputs);
        return myFunction.runCommands(t);
    }
    @Override
    public void setMyParameters(ArrayList<Executable>parameters){
        myInputs=parameters;
    }
}
