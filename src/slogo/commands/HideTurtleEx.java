package slogo.commands;

import slogo.configuration.CommandInterface;


public class HideTurtleEx extends Executable {

    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.hideTurtle();
    }

}
