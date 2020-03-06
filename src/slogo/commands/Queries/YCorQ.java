package slogo.commands.Queries;

import slogo.configuration.CommandInterface;

public class YCorQ extends Query {
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.getYCor();
    }
}
