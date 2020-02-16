package slogo;

import slogo.Variables.CVariable;
import slogo.commands.Executable;
import slogo.commands.ForEx;
import slogo.commands.ForwardEx;
import slogo.commands.HideTurtleEx;

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


        Class ref = Executable.class;

        Class[] classes = ref.getClasses();
        for(Class c:classes){
            System.out.println(c.getName());
        }



//        Class reflectClass = ForwardEx.class;
//        Constructor c = null;
//        try {
//             c= reflectClass.getConstructor(new Class[]{});
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        Executable ee=null;
//        try {
//            ee= (Executable) c.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        ArrayList<Executable> eList = new ArrayList<>();
//        Executable constant = new CVariable("tryout", 3);
//        eList.add(constant);
//        ee.setParameters(eList);
//        System.out.println(ee.runCommands(t));



        Executable e=p.reader(":test");
        System.out.println(e.runCommands(t));
        System.out.println(t.getShowing());
        HideTurtleEx hte=new HideTurtleEx();
        hte.runCommands(t);
        System.out.println(t.getShowing());

    }
}
