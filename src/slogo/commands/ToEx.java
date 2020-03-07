package slogo.commands;

import java.util.List;
import slogo.configuration.CommandInterface;

public class ToEx extends Executable {
    private Executable d;
    public ToEx(){
        setParametersAmounts(1);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return d.runCommands(cInterface);
    }

    @Override
    public void setMyParameters(List<Executable> parameters) {
        d=parameters.get(0);
    }

    @Override
    public boolean isFunction(){
        return true;
    }
}
