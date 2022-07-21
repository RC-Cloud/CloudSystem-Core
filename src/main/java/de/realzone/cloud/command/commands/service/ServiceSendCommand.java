package de.realzone.cloud.command.commands.service;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.api.CloudAPI;
import de.realzone.cloud.utils.MessageType;

import java.util.Scanner;

public class ServiceSendCommand {

    public static void onService(String[] args) {

            Scanner scanner = new Scanner(System.in);

            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("input_server_name"), MessageType.SAMELINE);
            String server = scanner.nextLine();

            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("service_send_command_input"), MessageType.SAMELINE);
            String serverTo = scanner.nextLine();

            CloudAPI.sendCommand(server, serverTo);


    }
}
