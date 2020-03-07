package slogo.commands;

import java.util.List;
import slogo.configuration.CommandInterface;

public class SetPenSizeEx extends Executable {
    private Executable d;
    public SetPenSizeEx(){
        setParametersAmounts(1);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.setPenColor(d.runCommands(cInterface));
    }

    @Override
    public void setMyParameters(List<Executable> parameters) {
        d=parameters.get(0);
    }
}