package slogo;

import slogo.Variables.VariableHolder;
import slogo.commands.Executable;

import java.util.ArrayList;

public class Function extends Executable{
    private VariableHolder funcVars;
    private Executable e;
    private ArrayList<String> inputVariableNames;
    private ArrayList<Executable> myInputs;
    public Function(VariableHolder funcVars, ArrayList<String> inputVariableNames, Executable e){
        this.funcVars=funcVars;
        this.inputVariableNames=inputVariableNames;
        this.e=e;
        setParametersAmounts(inputVariableNames.size());
    }

    @Override
    public int runCommands(Turtle t){
        int i=0;
        for(String variableName: inputVariableNames){
            funcVars.getVariable(variableName).setData(myInputs.get(i).runCommands(t));
            i++;
        }
        return e.runCommands(t);
    }

    @Override
    public void setMyParameters(ArrayList<Executable> parameters) {
        myInputs=parameters;
    }

}
