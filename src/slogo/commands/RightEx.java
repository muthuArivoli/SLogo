package slogo.commands;

import slogo.Turtle;
import slogo.Variables.Data;

public class RightEx extends Executable {
    private Data d;
    public RightEx(Data d){
        this.d=d;
    }
    @Override
    public int runCommands(Turtle t) {
        return t.left(d.getData());
    }
}
