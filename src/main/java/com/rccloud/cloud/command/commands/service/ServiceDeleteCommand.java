package com.rccloud.cloud.command.commands.service;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.api.CloudAPI;
import com.rccloud.cloud.utils.MessageType;

import java.util.Scanner;

public class ServiceDeleteCommand {

    public static void onService(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("service_delete_name"), MessageType.SAMELINE);
        String serverName = scanner.nextLine();

        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("service_delete_confirm"), MessageType.SAMELINE);
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("y")) {
            CloudAPI.deleteServer(serverName);
        } else if (answer.equalsIgnoreCase("n")) {
            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("cancelled"), MessageType.INFO);
            return;
        } else {
            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("cancelled"), MessageType.INFO);
            return;
        }
    }
}
