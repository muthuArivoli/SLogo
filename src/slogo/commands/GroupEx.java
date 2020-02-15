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
    public int runCommands(Turtle t) {
        int ret=0;
        for(Executable e:eList){
            ret = e.runCommands(t);
        }
        return ret;
    }
}
