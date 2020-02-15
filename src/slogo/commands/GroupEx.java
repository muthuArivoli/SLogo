package slogo.commands;

import slogo.Turtle;

import java.util.ArrayList;

public class GroupEx extends Executable {

    private ArrayList<Executable> eList;

    public GroupEx(){
        eList=new ArrayList<>();
    }

    public void addExecutable(Executable e){
        eList.add(e);
    }


    @Override
    public void runCommands(Turtle t) {
        for(Executable e:eList){
            e.runCommands(t);
        }
    }
}
