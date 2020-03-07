package slogo;

import java.util.List;
import slogo.Variables.VariableHolder;
import slogo.commands.Executable;
import slogo.configuration.CommandInterface;

public class Function extends Executable{
    private VariableHolder funcVars;
    private Executable e;
    private List<String> inputVariableNames;
    private List<Executable> myInputs;
    public Function(VariableHolder funcVars, List<String> inputVariableNames, Executable e){
        this.funcVars=funcVars;
        this.inputVariableNames=inputVariableNames;
        this.e=e;
        setParametersAmounts(inputVariableNames.size());
    }

    @Override
    public int runCommands(CommandInterface cInterface){
        int i=0;
        for(String variableName: inputVariableNames){
            funcVars.getVariable(variableName).setData(myInputs.get(i).runCommands(cInterface));
            i++;
        }
        return e.runCommands(cInterface);
    }

    @Override
    public void setMyParameters(List<Executable> parameters) {
        myInputs=parameters;
    }

}
