package slogo.commands;

import slogo.configuration.CommandInterface;

import java.util.List;

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
