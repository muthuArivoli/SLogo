package slogo.commands;

import slogo.Variables.CVariable;
import slogo.configuration.CommandInterface;

import java.util.List;

public class ForEx extends Executable {
    private CVariable myVariable;
    private Executable start;
    private Executable end;
    private Executable increment;
    private Executable e;
    public ForEx(){
        setParametersAmounts(2);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        int ret=0;
        for(int i = start.runCommands(cInterface); i<end.runCommands(cInterface); i+=increment.runCommands(cInterface)){
            myVariable.setData(i);
            ret=e.runCommands(cInterface);
        }
        return ret;
    }

    @Override
    public void setMyParameters(List<Executable> parameters) {
        List<Executable> groupMembers = getGroupFromExecutable(parameters.get(0)).getGroupMembers();
        if(groupMembers.size()!=4){
            System.out.println("Error: Expected 4 inputs in For and got: "+groupMembers.size());
            //Throw exception;
        }
        myVariable = getVariableFromExecutable(groupMembers.get(0));
        start=groupMembers.get(1);
        end=groupMembers.get(2);
        increment=groupMembers.get(3);
        e=parameters.get(2);
    }
}
