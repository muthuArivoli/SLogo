package slogo;

import slogo.ExecutableClassGetters.ExecutablesGetter;
import slogo.Variables.CVariable;
import slogo.Variables.VariableHolder;
import slogo.commands.Executable;
import slogo.commands.GroupEx;

import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    private VariableHolder myVariables;
    private ExecutablesGetter eg;

    public Parser(){
        myVariables=new VariableHolder();
        eg=new ExecutablesGetter();
    }


    public Executable parse(Scanner input){
        GroupEx runnableCode =new GroupEx();
        while (input.hasNextLine()) {
            Scanner line = new Scanner(input.nextLine());
            while (line.hasNext()) {
                runnableCode.addExecutable(nextInLine(input,line));
            }
        }
        return runnableCode;
    }




    private ArrayList<Executable> getParameters(int amount, Scanner input, Scanner line){
        ArrayList<Executable> ret = new ArrayList<>();
        for(int i = 0; i<amount;i++){
            System.out.println("param: "+(i+1));
            //Executable toAdd = mainParser(input,line);
            //if(toAdd==null)line=new Scanner(input.nextLine());
            ret.add(mainParser(input,line));
        }
        System.out.println("Finished finding "+ret.size()+" parameters");
        return ret;
    }

    private Executable getFinishedExecutable(String word, Scanner input, Scanner line){
        System.out.println(word);
        if(word.equals("[")){
            Executable group =  groupParser(input,line);
            System.out.println("groupFinished");
            return group;
        }
        if(word.equals("]")){
            return null;
        }
        Executable next=reader(word);
        if(next.needsVariable()){
            next.setVariable(nextVariableInLine(line));
        }
        ArrayList<Executable> myParameters=getParameters(next.getParametersAmounts(),input,line);
        next.setParameters(myParameters);
        return next;
    }

    public Executable groupParser(Scanner input, Scanner line){
        System.out.println("groupStart");
        GroupEx group =new GroupEx();
        while (line.hasNext()) {
            Executable next=nextInLine(input, line);
            if(next==null)return group;
            group.addExecutable(next);
        }
        while (input.hasNextLine()) {
            line = new Scanner(input.nextLine());
            while (line.hasNext()) {
                Executable next=nextInLine(input, line);
                if(next==null)return group;
                group.addExecutable(next);
            }
        }
        return null;
    }




    public Executable mainParser(Scanner input, Scanner line){
        while (line.hasNext()) {
            return nextInLine(input, line);
        }
        while (input.hasNextLine()) {
            line = new Scanner(input.nextLine());
            while (line.hasNext()) {
                return nextInLine(input, line);
            }
        }

        return null;
    }
    public CVariable nextVariableInLine(Scanner line){
        String word = line.next();
        return variableReader(word);
    }
    private Executable nextInLine(Scanner input, Scanner line){
        String word = line.next();
        try {
            int data = Integer.parseInt(word);
            System.out.println(data);
            return new CVariable("constant",data);
        }
        catch (NumberFormatException nfe) {
            return getFinishedExecutable(word,input,line);
        }
    }


    public Executable reader(String word){
        word=word.toLowerCase();
        if(word==null || word.equals("")){
            System.out.println("no word given to the reader");
            return null;
        }
        if(word.charAt(0)==':'){
            return myVariables.getVariable(word.substring(1));
        }
        if(eg.containsKey(word)){
            System.out.println(word+ " -> Getter");
            return eg.getExecutable(word);
        }
        return null;
    }

    public CVariable variableReader(String word){
        word=word.toLowerCase();
        if(word==null || word.equals("")){
            System.out.println("no word given to the variable reader");
            return null;
        }
        if(word.charAt(0)==':'){
            return myVariables.getVariable(word.substring(1));
        }
        else {
            System.out.println("given word is not a variable");
            return null;
        }
    }



}
