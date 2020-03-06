package slogo.commands;

import slogo.configuration.CommandInterface;

public class PenUpEx extends Executable {
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.penUp();
    }
}
