package slogo.commands;

import java.util.ArrayList;
import java.util.List;
import slogo.configuration.CommandInterface;

public class AskEx extends Executable {
    private ArrayList<Integer> turtles;
    private Executable ex;
    public AskEx(){
        setParametersAmounts(2);
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        ArrayList<Integer> tellValue = cInterface.ask(turtles);
        int ret = ex.runCommands(cInterface);
        cInterface.tell(tellValue);
        return ret;
    }

    @Override
    public void setMyParameters(List<Executable> parameters) {
        GroupEx myGroup=getGroupFromExecutable(parameters.get(0));
        turtles=new ArrayList<>();
        for(Executable e:myGroup.getGroupMembers()){
            turtles.add(getVariableFromExecutable(e).getData());
        }
        ex = parameters.get(1);
    }
}
