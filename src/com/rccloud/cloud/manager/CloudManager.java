package com.rccloud.cloud.manager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CloudManager {

    public Properties getLangProperties(){
        Properties properties = new Properties();
        try {
            InputStream in = new FileInputStream("/home/cloud/lang/lang.properties");
            properties.load(in);
        }catch (IOException e){
            e.printStackTrace();
        }
        return properties;
    }

}
