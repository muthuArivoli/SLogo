package slogo.commands;

import java.util.ArrayList;
import java.util.List;
import slogo.configuration.CommandInterface;

public class TellEx extends Executable {
    private ArrayList<Integer> turtles;
    public TellEx(){
        setParametersAmounts(1);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        return cInterface.tell(turtles);
    }

    @Override
    public void setMyParameters(List<Executable> parameters) {
        GroupEx myGroup=getGroupFromExecutable(parameters.get(0));
        turtles=new ArrayList<>();
        for(Executable e:myGroup.getGroupMembers()){
            turtles.add(getVariableFromExecutable(e).getData());
        }
    }
}
