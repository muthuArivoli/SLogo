package slogo.commands;

import slogo.Turtle;
import slogo.Variables.CVariable;

import java.util.ArrayList;

public abstract class Executable {
    protected int parametersAmounts;

    public abstract int runCommands(Turtle t);

    public int getParametersAmounts(){
        return parametersAmounts;
    }
    public void setParameters(ArrayList<Executable> parameters){
        if(this.parametersAmounts!=parameters.size()){
            System.out.println("wrong amount of parameters");
        }
        setMyParameters(parameters);
    }
    protected void setMyParameters(ArrayList<Executable>parameters){
        return;
    }

    public boolean needsVariable(){
        return false;
    }

    protected void setParametersAmounts(int amount){
        parametersAmounts=amount;
    }

    public void setVariable(CVariable myVariable){
        return;
    }

}
