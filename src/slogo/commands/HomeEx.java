package slogo.commands;

import slogo.configuration.CommandInterface;

public class HomeEx extends Executable {
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.home();
    }
}
