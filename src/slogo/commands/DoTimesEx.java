package slogo.commands;

import java.util.List;
import slogo.Variables.CVariable;
import slogo.configuration.CommandInterface;

public class DoTimesEx extends Executable {
    private CVariable myVariable;
    private Executable limit;
    private Executable e;


    public DoTimesEx(){
        setParametersAmounts(2);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        int ret=0;
        for(int i = 0; i<limit.runCommands(cInterface); i++){
            myVariable.setData(i);
            ret=e.runCommands(cInterface);
        }
        return ret;
    }

    @Override
    public void setMyParameters(List<Executable> parameters) {
        List<Executable> groupMembers = getGroupFromExecutable(parameters.get(0)).getGroupMembers();
        if(groupMembers.size()!=2){
            System.out.println("Error: Expected 2 inputs in DoTimes and got: "+groupMembers.size());
            //Throw exception;
        }
        myVariable = getVariableFromExecutable(groupMembers.get(0));
        limit=groupMembers.get(1);
        e=parameters.get(1);
    }
}
