package slogo.commands;

import slogo.Turtle;
import slogo.Variables.CVariable;

import java.util.List;

public abstract class Executable {
    protected int parametersAmounts;

    public abstract int runCommands(Turtle t);

    public int getParametersAmounts(){
        return parametersAmounts;
    }
    public void setParameters(List<Executable> parameters){
        if(this.parametersAmounts!=parameters.size()){
            System.out.println("wrong amount of parameters");
        }
        setMyParameters(parameters);
    }
    protected void setMyParameters(List<Executable> parameters){
        return;
    }

    public boolean needsVariable(){
        return false;
    }

    public boolean needsGroupedInputs(){
        return false;
    }

    public boolean isFunction(){
        return false;
    }

    protected void setParametersAmounts(int amount){
        parametersAmounts=amount;
    }

    public void setVariable(CVariable myVariable){
        return;
    }

}
