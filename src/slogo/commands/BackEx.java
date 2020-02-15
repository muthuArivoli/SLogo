package slogo.commands;

import slogo.Turtle;
import slogo.Variables.Data;

public class BackEx extends Executable {
    private Data d;
    public BackEx(Data d){
        this.d=d;
    }
    @Override
    public int runCommands(Turtle t) {
        return t.back(d.getData());
    }
}
