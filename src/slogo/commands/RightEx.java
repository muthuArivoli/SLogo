package slogo.commands;

import java.util.List;
import slogo.configuration.CommandInterface;

public class RightEx extends Executable {
    private Executable d;
    public RightEx(){
        setParametersAmounts(1);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.right(d.runCommands(cInterface));
    }
    @Override
    public void setMyParameters(List<Executable> parameters) {
        d=parameters.get(0);
    }
}
