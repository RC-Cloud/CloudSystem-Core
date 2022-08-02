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

public class TemplateUseCommand {

    public static void onTemplate(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("input_template_name"), MessageType.SAMELINE);
        String templateName = scanner.nextLine();


        File serverDir = new File("/home/servers/" + templateName);
        File templateDir = new File("/home/cloud/templates/");

        if (APIUtils.findServer(templateName)) {

            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("server_already_exists"), MessageType.INFO);
        } else {
            if (!Files.exists(Paths.get("/home/servers/" + templateName))) {
                templateDir.mkdir();
            }

            if (!Files.exists(Paths.get("/home/servers/"))) {
                templateDir.mkdir();
                try {
                    FileUtils.copyDirectory(templateDir, new File("/home/servers/"));
                    RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("template_used"), MessageType.INFO);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {

                try {
                    FileUtils.copyDirectory(templateDir, new File("/home/servers/"));
                    RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("template_used"), MessageType.INFO);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
