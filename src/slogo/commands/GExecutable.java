package slogo.commands;

import slogo.Variables.CVariable;

public abstract class GExecutable extends VExecutable{
    protected CVariable myVariable;
    @Override
    public boolean needsGroupedInputs(){
        return true;
    }
    @Override
    public void setVariable(CVariable myVariable){
        this.myVariable=myVariable;
    }
}
