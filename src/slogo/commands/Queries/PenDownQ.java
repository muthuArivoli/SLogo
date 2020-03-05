package slogo.commands.Queries;

import slogo.configuration.CommandInterface;

public class PenDownQ extends Query {
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.getPenDown();
    }
}
