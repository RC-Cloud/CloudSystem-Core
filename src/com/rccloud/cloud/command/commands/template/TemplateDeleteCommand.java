package com.rccloud.cloud.command.commands.template;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.api.utils.APIUtils;
import com.rccloud.cloud.utils.MessageType;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class TemplateDeleteCommand {

    public static void onTemplate(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("input_template_name"), MessageType.SAMELINE);
        String templateName = scanner.nextLine();

        File templateDir = new File("/home/cloud/templates/" + templateName);
        if (Files.exists(Paths.get("/home/cloud/templates/" + templateName))) {
            APIUtils.deleteDirectory(templateDir);
            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("template_deleted"), MessageType.INFO);
        } else {
            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("template_not_found"), MessageType.ERROR);
            return;
        }

    }
}
