package com.rccloud.cloud.command.commands.template;

import com.google.gson.Gson;
import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.api.CloudAPI;
import com.rccloud.cloud.api.utils.APIUtils;
import com.rccloud.cloud.utils.MessageType;

import java.io.File;
import java.io.Reader;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;

public class TemplateInfoCommand {

    public static void onTemplate(String[] args){
        Scanner scanner = new Scanner(System.in);

        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("input_template_name"), MessageType.SAMELINE);
        String serverName = scanner.nextLine();

        if(Files.exists(Paths.get("/home/cloud/templates/" + serverName))){

            try {
                Gson gson = new Gson();

                Reader reader = Files.newBufferedReader(Paths.get("/home/cloud/templates/" + serverName + "/cloud.json"));

                Map<?, ?> map = gson.fromJson(reader, Map.class);

                RCCloud.getConsoleManager().sendMessage(" ", MessageType.NOTHING);
                RCCloud.getConsoleManager().sendMessage("Name: " + map.get("name"), MessageType.NOTHING);
                RCCloud.getConsoleManager().sendMessage("Version: " + map.get("version"), MessageType.NOTHING);
                RCCloud.getConsoleManager().sendMessage("Port: " + map.get("port").toString().split("\\.")[0], MessageType.NOTHING);
                RCCloud.getConsoleManager().sendMessage("Server Software: " + map.get("type"), MessageType.NOTHING);
                RCCloud.getConsoleManager().sendMessage(" ", MessageType.NOTHING);

                reader.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else{
            RCCloud.getCloudManager().getLangProperties().getProperty("template_not_found");
            return;
        }
    }
}
