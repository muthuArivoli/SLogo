package slogo.commands.Queries;

import slogo.Turtle;

public class ShowingQ extends Query {
    @Override
    public int runCommands(Turtle t) {
        return t.getShowing();
    }
}
