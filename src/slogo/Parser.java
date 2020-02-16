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
                String word = line.next();
                Executable next=getFinishedExecutable(word,input,line);

                runnableCode.addExecutable(next);
            }
        }
        return runnableCode;
    }
    private ArrayList<Executable> getParameters(int amount, Scanner input, Scanner line){
        ArrayList<Executable> ret = new ArrayList<>();
        for(int i = 0; i<amount;i++){
            mainParser(input,line);
        }
        return ret;
    }

    private Executable getFinishedExecutable(String word, Scanner input, Scanner line){
        Executable next=reader(word);
        next.setParameters(getParameters(next.getParametersAmounts(),input,line));
        return next;
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
    private Executable nextInLine(Scanner input, Scanner line){
        if(line.hasNextInt()){
            int data = line.nextInt();
            return new CVariable("constant",data);
        }
        else {
            String word = line.next();
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
