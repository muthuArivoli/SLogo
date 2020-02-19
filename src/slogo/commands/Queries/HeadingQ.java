package slogo.commands.Queries;

import slogo.Turtle;

public class HeadingQ extends Query {
    @Override
    public int runCommands(Turtle t) {
        return t.getHeading();
    }
}
