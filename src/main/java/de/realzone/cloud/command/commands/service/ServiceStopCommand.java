package de.realzone.cloud.command.commands.service;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.api.CloudAPI;
import de.realzone.cloud.utils.MessageType;

import java.util.Scanner;

public class ServiceStopCommand {

    public static void onService(String[] args) {

            Scanner scanner = new Scanner(System.in);

            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("input_server_name"), MessageType.SAMELINE);
            String server = scanner.nextLine();

            CloudAPI.stopServer(server);


    }
}
