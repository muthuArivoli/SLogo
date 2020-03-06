package slogo.commands;

import slogo.configuration.CommandInterface;

public class PenDownEx extends Executable {
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.penDown();
    }
}
