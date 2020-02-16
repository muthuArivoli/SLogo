package slogo.commands;

import slogo.Turtle;

public class ForwardEx extends Executable {
    private Executable d;
    public ForwardEx(Executable d){
        this.d=d;
    }
    @Override
    public int runCommands(Turtle t) {
        return t.forward(d.runCommands(t));
    }
}
