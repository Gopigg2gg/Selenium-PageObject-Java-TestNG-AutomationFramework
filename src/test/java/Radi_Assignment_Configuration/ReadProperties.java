package Radi_Assignment_Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static ReadProperties instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir")+
            "/src/test/properties/config.properties";
    private static String url;
    public static ReadProperties getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new ReadProperties();
                instance.loadData();
            }
        }
        return instance;
    }
    //Get all configuration data and assign to related fields.
    private void loadData() {
        //Declare a properties object
        Properties prop = new Properties();
 
        //Read configuration.properties file
        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
 
        //Get properties from configuration.properties
        url = prop.getProperty("url");
    }
    public String getURL () {
      return url;
    }

}
