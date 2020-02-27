package slogo.commands.Queries;

import slogo.Turtle;

public class XCorQ extends Query {
    @Override
    public int runCommands(Turtle t) {
        return t.getXCor();
    }
}
