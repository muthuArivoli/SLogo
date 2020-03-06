package slogo.Variables;

import slogo.Operations.Operation;
import slogo.commands.Executable;
import slogo.configuration.CommandInterface;

import java.util.ArrayList;
import java.util.List;

public class OpData extends Executable {

    private Operation o;
    private List<Executable> eList;

    public OpData(Operation o){
        this.o=o;
        setParametersAmounts(o.getNumInputs());
    }
    @Override
    public int runCommands(CommandInterface cInterface) {
        ArrayList<Integer> inputs =new ArrayList<>();
        for(Executable e:eList){
            inputs.add(e.runCommands(cInterface));
        }
        return o.getResult(inputs);
    }
    @Override
    public void setMyParameters(List<Executable> parameters) {
        eList=parameters;
    }
}
