package slogo.commands.Queries;

import slogo.Turtle;
import slogo.commands.Queries.Query;

public class XCorQ extends Query {
    @Override
    public int runCommands(Turtle t) {
        return t.getXCor();
    }
}
