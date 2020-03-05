package slogo.commands;

import slogo.configuration.CommandInterface;

import java.util.List;

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
