package slogo.commands;

import slogo.Turtle;
import slogo.Variables.CVariable;

public class ForEx extends Executable {
    private CVariable v;
    private Executable start;
    private Executable end;
    private Executable increment;
    private Executable e;
    public ForEx(CVariable v, Executable start, Executable end, Executable increment, Executable e){
        this.v=v;
        this.start=start;
        this.end = end;
        this.increment=increment;
        this.e = e;
    }
    @Override
    public int runCommands(Turtle t) {
        int ret=0;
        for(int i = start.runCommands(t); i<end.runCommands(t); i+=increment.runCommands(t)){
            v.setData(i);
            ret=e.runCommands(t);
        }
        return ret;
    }
}
