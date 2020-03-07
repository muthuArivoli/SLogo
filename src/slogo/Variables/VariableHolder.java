package slogo.Variables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VariableHolder {
    HashMap<String, CVariable> myVariables;

    public VariableHolder(){
        myVariables=new HashMap<>();
    }

    public CVariable makeVariable(String name, int data){
        name=name.toLowerCase();
        myVariables.put(name,new CVariable(name, data));
        return myVariables.get(name);
    }

    public CVariable getVariable(String name){
        name=name.toLowerCase();
        if(!myVariables.containsKey(name)){
            myVariables.put(name, new CVariable(name));
        }
        return myVariables.get(name);
    }

    public void setVariable(String name, CVariable var){
        myVariables.replace(name, var);
    }
    /**
     * Used for variable table view
     * @return Collection of CVariable values
     */
    public List<CVariable> getVariables() {
        return new ArrayList<>(myVariables.values());
    }
}
