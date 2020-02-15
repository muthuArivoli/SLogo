package slogo.commands;

import slogo.Turtle;
import slogo.Variables.Data;

public class If extends Executable {
    private Data d;
    private Executable e;
    public If(Data d, Executable e){
        this.d=d;
        this.e=e;
    }
    @Override
    public int runCommands(Turtle t) {
        int ret=0;
        if(d.getData()!=0){
            ret=e.runCommands(t);
        }
        return ret;
    }
}
