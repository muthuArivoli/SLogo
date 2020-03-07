package slogo.configuration;

import java.io.*;
import java.util.Properties;

public class Property {
    String result = "";
    InputStream inputStream;

    public String getPropValues(String input) throws Exception {
        Properties prop = new Properties();
        String propFileName = "slogo/configuration/config.properties";
        inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
            // get the property value and print it out
        result = prop.getProperty(input);
        inputStream.close();
        return result;
    }
}
