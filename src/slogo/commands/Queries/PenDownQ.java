package slogo.commands.Queries;

import slogo.Turtle;

public class PenDownQ extends Query {
    @Override
    public int runCommands(Turtle t) {
        return t.getPenDown();
    }
}
