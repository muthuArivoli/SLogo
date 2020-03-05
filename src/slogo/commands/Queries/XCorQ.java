package slogo.commands.Queries;

import slogo.configuration.CommandInterface;

public class XCorQ extends Query {
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.getXCor();
    }
}
