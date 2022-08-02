package com.rccloud.cloud.command.commands.template;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.api.utils.APIUtils;
import com.rccloud.cloud.utils.MessageType;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class TemplateCreateCommand {

    public static void onTemplate(String[] args){

        Scanner scanner = new Scanner(System.in);

        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("input_template_name"), MessageType.SAMELINE);
        String templateName = scanner.nextLine();

        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("input_server_name"), MessageType.SAMELINE);
        String server = scanner.nextLine();

        File serverDir = new File("/home/servers/" + server);
        File templateDir = new File("/home/cloud/templates/");

        if(APIUtils.findServer(server)){

            if(!Files.exists(Paths.get("/home/cloud/templates"))){
                templateDir.mkdir();
            }

            if(!Files.exists(Paths.get("/home/cloud/templates/" + templateName))){
                templateDir.mkdir();
            }else{
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("template_already_exists"), MessageType.ERROR);
                return;
            }

            try {
                FileUtils.copyDirectory(serverDir, new File("/home/cloud/templates/" + templateName));
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("template_created"), MessageType.INFO);
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("server_not_found"), MessageType.ERROR);
            return;
        }

    }
}
