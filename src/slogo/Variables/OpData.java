package slogo.Variables;

import slogo.Operations.Operation;
import slogo.Turtle;
import slogo.commands.Executable;

import java.util.ArrayList;

public class OpData extends Executable {

    private Operation o;
    private ArrayList<Executable> eList;

    public OpData(Operation o, ArrayList<Executable> eList){
        this.o=o;
        this.eList=eList;
    }
    @Override
    public int runCommands(Turtle t) {
        ArrayList<Integer> inputs =new ArrayList<>();
        for(Executable e:eList){
            inputs.add(e.runCommands(t));
        }
        return o.getResult(inputs);
    }
}
