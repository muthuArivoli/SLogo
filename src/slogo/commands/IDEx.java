package slogo.commands;

import slogo.configuration.CommandInterface;

public class IDEx extends Executable {
    public IDEx(){
        setParametersAmounts(0);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.id();
    }
}