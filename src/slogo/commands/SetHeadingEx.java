package slogo.commands;

import slogo.Turtle;
import slogo.Variables.Data;

public class SetHeadingEx extends Executable {
    private Data d;
    public SetHeadingEx(Data d){
        this.d=d;
    }
    @Override
    public int runCommands(Turtle t) {
        return t.setHeading(d.getData());
    }
}
