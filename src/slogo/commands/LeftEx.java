package slogo.commands;

import java.util.List;
import slogo.configuration.CommandInterface;

public class LeftEx extends Executable {
    private Executable d;
    public LeftEx(){
        setParametersAmounts(1);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.left(d.runCommands(cInterface));
    }
    @Override
    public void setMyParameters(List<Executable> parameters) {
        d=parameters.get(0);
    }
}
