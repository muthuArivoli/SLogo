package slogo.commands;

import slogo.Turtle;
import slogo.Variables.CVariable;
import slogo.Variables.Data;

public class ForEx extends Executable {
    private CVariable v;
    private Data start;
    private Data end;
    private Data increment;
    private Executable e;
    public ForEx(CVariable v, Data start, Data end, Data increment, Executable e){
        this.v=v;
        this.start=start;
        this.end = end;
        this.increment=increment;
        this.e = e;
    }
    @Override
    public int runCommands(Turtle t) {
        int ret=0;
        for(int i = start.getData(); i<end.getData();i+=increment.getData()){
            v.setData(i);
            ret=e.runCommands(t);
        }
        return ret;
    }
}
