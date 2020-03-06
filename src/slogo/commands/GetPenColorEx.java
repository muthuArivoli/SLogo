package slogo.commands;

import slogo.configuration.CommandInterface;

public class GetPenColorEx extends Executable {
    public GetPenColorEx(){
        setParametersAmounts(0);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.getPenColor();
    }
}