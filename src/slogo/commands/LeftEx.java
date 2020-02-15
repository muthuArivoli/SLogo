package slogo.commands;

import slogo.Turtle;
import slogo.Variables.Data;

public class LeftEx extends Executable {
    private Data d;
    public LeftEx(Data d){
        this.d=d;
    }
    @Override
    public int runCommands(Turtle t) {
        return t.left(d.getData());
    }
}
