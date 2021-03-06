package slogo.commands;

import java.util.List;
import slogo.Function;
import slogo.configuration.CommandInterface;

public class CommandEx extends Executable{
    private Function myFunction;
    private List<Executable> myInputs;

    public CommandEx(Function f){
        myFunction=f;
        setParametersAmounts(f.getParametersAmounts());
    }

    @Override
    public int runCommands(CommandInterface cInterface) {
        myFunction.setParameters(myInputs);
        return myFunction.runCommands(cInterface);
    }
    @Override
    public void setMyParameters(List<Executable> parameters){
        myInputs=parameters;
    }
}
