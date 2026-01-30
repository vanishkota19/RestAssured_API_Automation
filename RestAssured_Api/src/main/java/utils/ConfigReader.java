package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        String env = System.getProperty("env", "qa"); // default = qa
        String fileName = "config/" + env + ".properties";

        try (InputStream is =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream(fileName)) {

            if (is == null) {
                throw new RuntimeException("Config file not found: " + fileName);
            }
            properties.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config for env: " + env);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
