package com.epam.wizzair.helper;

import java.io.InputStream;
import java.util.Properties;


public class Config {


    private static Properties config = new Properties();

    private static InputStream is = Config.class.getResourceAsStream("/config.properties");
    static {
        try{
            config.load(is);
        } catch (Exception e){
            System.out.println("Error reading from property file");
        }
    }

    public static String urlMain() {
        return config.getProperty("urlMain");
    }

    public static String urlTimetable() {return config.getProperty("urlTimetable");}

    public static String browser() {
        return config.getProperty("browser");
    }

    public static String geckodriver() {return config.getProperty("geckodriver");}

    public static String chromedriver() {return config.getProperty("chromedriver");}

    public static String profile(){
        return config.getProperty("profile");
    }

    public static int timeout(){
        int result = 15;
        try {
            result = Integer.parseInt(config.getProperty("timeOut"));
        } catch (NumberFormatException e) {
            //todo logging
        }
        return result;
    }





}
