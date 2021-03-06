package slogo.commands;

import java.util.List;
import slogo.Variables.CVariable;
import slogo.configuration.CommandInterface;

public class SetEx extends Executable {
    private CVariable myVariable;
    private Executable setTo;
    public SetEx(){
        setParametersAmounts(2);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return myVariable.setData(setTo.runCommands(cInterface));
    }
    @Override
    public void setMyParameters(List<Executable> parameters) {
        myVariable = getVariableFromExecutable(parameters.get(0));
        setTo=parameters.get(1);
    }
}
