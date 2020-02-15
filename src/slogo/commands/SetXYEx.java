package slogo.commands;

import slogo.Turtle;
import slogo.Variables.Data;

public class SetXYEx extends Executable {
    private Data d1;
    private Data d2;
    public SetXYEx(Data d1, Data d2){
        this.d1=d1;
        this.d2=d2;
    }
    @Override
    public int runCommands(Turtle t) {
        return t.setXY(d1.getData(), d2.getData());
    }
}
