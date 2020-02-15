package slogo;

import slogo.commands.Executable;

import java.util.Scanner;

public class Parser {

    public Executable mainParser(String input){
        Scanner sc =new Scanner(input);
        while (sc.hasNextLine()) {
            Scanner s = new Scanner(sc.nextLine());
            while (s.hasNext()) {
                String word = s.next();

            }
        }
        return null;
    }
}
