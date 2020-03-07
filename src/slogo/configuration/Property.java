package slogo.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {
    String result = "";
    InputStream inputStream;

    public String getPropValues(String input) {
        Properties prop = new Properties();
        String propFileName = "slogo/configuration/config.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            try {
                prop.load(inputStream);
            }
            catch(IOException e){
                System.out.println("Could not load input stream");
            }
        } else {
            System.out.println("property file '" + propFileName + "' not found in the classpath");
        }
            // get the property value and print it out
        result = prop.getProperty(input);
        try {
            inputStream.close();
        }
        catch(IOException e){
            System.out.println("Could not close input stream");
        }
        return result;
    }
}
