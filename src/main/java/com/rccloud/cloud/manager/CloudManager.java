package com.rccloud.cloud.manager;

import java.io.IOException;
import java.util.Properties;

public class CloudManager {

    public Properties getLangProperties(){
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream("lang.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return properties;
    }

}
