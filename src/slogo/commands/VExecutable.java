package slogo.commands;

import slogo.Variables.CVariable;

public abstract class VExecutable extends Executable{
    protected CVariable myVariable;
    @Override
    public boolean needsVariable(){
        return true;
    }
    @Override
    public void setVariable(CVariable myVariable){
        this.myVariable=myVariable;
    }
}
