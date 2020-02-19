package slogo.commands.Queries;

import slogo.Turtle;

public class YCorQ extends Query {
    @Override
    public int runCommands(Turtle t) {
        return t.getYCor();
    }
}
