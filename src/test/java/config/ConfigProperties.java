package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
    private static Properties properties;

    static {
        try (InputStream input = ConfigProperties.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("BASE_URL", "http://127.0.0.1");
    }

    public static String getBrowserSize() {
        return properties.getProperty("BROWSER_SIZE", "1920x1080");
    }

    public static String getHomePage(){
        return properties.getProperty("HOME_PAGE", "/");
    }
    public static String getUser(){
        return properties.getProperty("USER", "admin");
    }
    public static String getPassword(){
        return properties.getProperty("PASSWORD", "admin");
    }
    public static String getInvalidUserPassword(){
        return properties.getProperty("INVALID_USER_PASSWORD", "invalid");
    }
    public static String getUserApi(){
        return properties.getProperty("USER_API", "dmitro");
    }
    public static String getPasswordApi(){
        return properties.getProperty("PASSWORD_API", "dmitro");
    }
    public static String getApiLogin(){
        return properties.getProperty("API_LOGIN", "jsonrpc");
    }
    public static String getApiToken(){
        return properties.getProperty("API_TOKEN", "c8841f5c5ab7208e3c58e672b555d6250cf9f35e54c23d6c7db37a881843");
    }
    public static String getBrowserType() {
        return properties.getProperty("BROWSER_TYPE", "chrome");
    }
    public static String getApiEndpoint(){
        return properties.getProperty("API_ENDPOINT", "/jsonrpc.php");
    }
    public static int getUserId(){
        return Integer.parseInt(properties.getProperty("USER_ID"));
    }
    public static int getProjectId(){
        return Integer.parseInt(properties.getProperty("PROJECT_ID"));
    }
    public static int getTaskId(){
        return Integer.parseInt(properties.getProperty("TASK_ID"));
    }
}
