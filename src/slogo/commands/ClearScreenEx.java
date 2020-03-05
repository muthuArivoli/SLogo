package slogo.commands;

import slogo.configuration.CommandInterface;

public class ClearScreenEx extends Executable {
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.clearScreen();
    }
}
