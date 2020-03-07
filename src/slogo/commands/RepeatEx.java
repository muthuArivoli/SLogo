package slogo.commands;

import java.util.List;
import slogo.configuration.CommandInterface;

public class RepeatEx extends Executable {
    private Executable amount;
    private Executable e;


    public RepeatEx(){
        setParametersAmounts(2);
    }


    @Override
    public int runCommands(CommandInterface cInterface) {
        int ret=0;
        for(int i = 0; i<amount.runCommands(cInterface); i++){
            ret=e.runCommands(cInterface);
        }
        return ret;
    }
    @Override
    public void setMyParameters(List<Executable> parameters) {
        amount=parameters.get(0);
        e=parameters.get(1);
    }
}
