package slogo.commands;

import slogo.Turtle;
import slogo.Variables.Data;

public class ForwardEx extends Executable {
    private Data d;
    public ForwardEx(Data d){
        this.d=d;
    }
    @Override
    public int runCommands(Turtle t) {
        return t.forward(d.getData());
    }
}
