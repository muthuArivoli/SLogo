package slogo.commands;

import java.util.List;
import slogo.configuration.CommandInterface;

public class ForwardEx extends Executable {
    private Executable d;
    public ForwardEx(){
        setParametersAmounts(1);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.forward(d.runCommands(cInterface));
    }

    @Override
    public void setMyParameters(List<Executable> parameters) {
        d=parameters.get(0);
    }
}
