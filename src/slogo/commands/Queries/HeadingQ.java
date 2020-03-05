package slogo.commands.Queries;

import slogo.configuration.CommandInterface;

public class HeadingQ extends Query {
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.getHeading();
    }
}
