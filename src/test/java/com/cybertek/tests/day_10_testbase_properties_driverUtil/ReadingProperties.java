package com.cybertek.tests.day_10_testbase_properties_driverUtil;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_file() throws Exception {

        Properties properties = new Properties();

        String path = "configuration.properties";

        FileInputStream file = new FileInputStream(path);

        properties.load(file);

        String a = properties.getProperty("browser");
        String b = properties.getProperty("username");

        System.out.println("browser = " + a);
        System.out.println("username = " + b);

        file.close();
    }

    @Test
    public void using_properties_utility_method(){
        String a = ConfigurationReader.getProperty("browser");
        String b = ConfigurationReader.getProperty("smartbearURL");

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
