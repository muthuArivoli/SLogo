package slogo.commands.Queries;

import slogo.configuration.CommandInterface;

public class ShowingQ extends Query {
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.getShowing();
    }
}
