package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    Properties properties = new Properties();

    public String getProp(String key) {
        try {
            if (System.getProperty("env") == null) {
                //getResourceAsStream irá ler meu arquivo (dev/hom)
                properties.load(getClass().getClassLoader().getResourceAsStream("hom.properties"));
            } else {
                properties.load(getClass().getClassLoader().getResourceAsStream(System.getProperty("env")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }
}
