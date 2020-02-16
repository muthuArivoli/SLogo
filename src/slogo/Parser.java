package slogo;

import slogo.Variables.VariableHolder;
import slogo.commands.Executable;

import java.util.Scanner;

public class Parser {

    private VariableHolder myVariables;

    public Parser(){
        myVariables=new VariableHolder();
    }

    public Executable mainParser(Scanner input){
        while (input.hasNextLine()) {
            Scanner s = new Scanner(input.nextLine());
            while (s.hasNext()) {
                String word = s.next();

            }
        }
        return null;
    }
}
