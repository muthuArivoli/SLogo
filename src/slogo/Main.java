package slogo;

import slogo.Variables.CVariable;
import slogo.commands.Executable;
import slogo.commands.ForEx;
import slogo.commands.ForwardEx;
import slogo.commands.HideTurtleEx;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Feel free to completely change this code or delete it entirely. 
 */
public class Main {
    /**
     * Start of the program.
     */
    public static void main (String[] args) {

        Parser p=new Parser();
        Turtle t=new Turtle();

        File file = new File("data/examples/loops_with_variables/microwave.logo");
        Scanner sc = null;

        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("the file was not found");
        }

        Executable circle = p.parse(sc);

        sc.close();

        circle.runCommands(t);

    }
}
