package slogo.commands;

import slogo.Turtle;
import slogo.Variables.CVariable;

public class SetEx extends Executable {
    private CVariable myVar;
    private int setTo;
    public SetEx(CVariable var, int data){
        this.myVar=var;
        this.setTo=data;
    }
    @Override
    public int runCommands(Turtle t) {
        myVar.setData(setTo);
        return setTo;
    }
}
