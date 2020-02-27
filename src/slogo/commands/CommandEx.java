package slogo.commands;

import slogo.Function;
import slogo.Turtle;

import java.util.List;

public class CommandEx extends Executable{
    private Function myFunction;
    private List<Executable> myInputs;

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
    public void setMyParameters(List<Executable> parameters){
        myInputs=parameters;
    }
}
