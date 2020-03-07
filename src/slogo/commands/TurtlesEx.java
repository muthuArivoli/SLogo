package slogo.commands;

import slogo.configuration.CommandInterface;

import java.util.List;

public class TurtlesEx extends Executable {
    public TurtlesEx(){
        setParametersAmounts(0);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.turtles();
    }
}