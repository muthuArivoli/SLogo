package slogo.commands;

import slogo.Turtle;

public class SetHeadingEx extends Executable {
    private Executable d;
    public SetHeadingEx(Executable d){
        this.d=d;
    }
    @Override
    public int runCommands(Turtle t) {
        return t.setHeading(d.runCommands(t));
    }
}
