package de.realzone.cloud.command.commands.service;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.api.CloudAPI;
import de.realzone.cloud.command.Command;
import de.realzone.cloud.utils.MessageType;

import java.util.Scanner;

import static de.realzone.cloud.utils.Utils.sendServiceHelpMessage;

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
