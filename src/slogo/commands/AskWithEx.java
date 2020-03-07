package slogo.commands;

import slogo.configuration.CommandInterface;

import java.util.ArrayList;
import java.util.List;

public class AskWithEx extends Executable {
    private Executable condition;
    private Executable ex;
    public AskWithEx(){
        setParametersAmounts(2);
    }

    @Override
    public int runCommands(CommandInterface cInterface) {
        ArrayList<Integer> tellValue = cInterface.askWith(condition);
        int ret = ex.runCommands(cInterface);
        cInterface.tell(tellValue);
        return ret;
    }

    @Override
    public void setMyParameters(List<Executable> parameters) {
        condition =parameters.get(0);
        ex = parameters.get(1);
    }
}
