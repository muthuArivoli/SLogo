package slogo.commands;

import slogo.configuration.CommandInterface;

public class ShowTurtleEx extends Executable {
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.showTurtle();
    }
}
