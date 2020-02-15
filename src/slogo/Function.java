package slogo;

import slogo.Variables.VariableHolder;
import slogo.commands.Executable;

import java.util.ArrayList;
import java.util.List;

public class Function {
    private VariableHolder funcVars;
    private Executable e;
    private ArrayList<String> inputVariableNames;
    public Function(VariableHolder funcVars, ArrayList<String> inputVariableNames, Executable e){
        this.funcVars=funcVars;
        this.inputVariableNames=inputVariableNames;
        this.e=e;
    }

    public int runCommand(List<Integer> inputs, Turtle t){
        int ret=0;
        if(inputs.size()!=inputVariableNames.size()){
            System.out.println("Error: incorrect amount of inputs");
            return ret;
        }
        int i=0;
        for(String variableName: inputVariableNames){
            funcVars.getVariable(variableName).setData(inputs.get(i));
            i++;
        }
        ret=e.runCommands(t);
        return ret;
    }

}
