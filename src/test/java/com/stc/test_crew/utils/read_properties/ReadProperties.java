package com.stc.test_crew.utils.read_properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ReadProperties {
   private ReadProperties(){}

   private static final String ROOT_PATH = System.getProperty("user.dir") +"/src/test/java/resources/";
   private static final String STC_CONFIG_PATH =ROOT_PATH.concat("stc_config.properties");
    public static Properties setStcConfig() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(STC_CONFIG_PATH);
        configProperties.load(inputStream);
        return configProperties;
    }
}
