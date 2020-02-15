package slogo.commands;

import slogo.Turtle;
import slogo.Variables.CVariable;
import slogo.Variables.Data;

public class DoTimesEx extends Executable {
    private CVariable v;
    private Data limit;
    private Executable e;


    public DoTimesEx(CVariable var, Data limit, Executable e){
        this.v=var;
        this.limit=limit;
        this.e=e;
    }
    @Override
    public int runCommands(Turtle t) {
        int ret=0;
        for(int i=0;i<limit.getData();i++){
            v.setData(i);
            ret=e.runCommands(t);
        }
        return ret;
    }
}
