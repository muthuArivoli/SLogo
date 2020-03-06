package slogo.commands;

import slogo.configuration.CommandInterface;

public class GetShapeEx extends Executable {
    public GetShapeEx(){
        setParametersAmounts(0);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.getShape();
    }
}