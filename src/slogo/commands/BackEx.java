package slogo.commands;

import java.util.List;
import slogo.configuration.CommandInterface;

public class BackEx extends Executable {
    private Executable d;
    public BackEx(){
        setParametersAmounts(1);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.back(d.runCommands(cInterface));
    }

    @Override
    public void setMyParameters(List<Executable> parameters) {
        d=parameters.get(0);
    }
}
