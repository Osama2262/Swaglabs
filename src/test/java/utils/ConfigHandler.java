package utils;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigHandler {
    Properties properties;









    public ConfigHandler(String filePath) {
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream(filePath);
            properties.load(file);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

    public String getValue(String value)
    {
        return properties.getProperty(value);
    }
}
