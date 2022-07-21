package de.realzone.cloud.command.commands.service;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.api.CloudAPI;
import de.realzone.cloud.command.Command;
import de.realzone.cloud.utils.MessageType;
import de.realzone.cloud.utils.Utils;

import java.util.Scanner;


public class ServiceInfoCommand {

    public static void onService(String[] args) {
        if(args.length == 0){
            Utils.sendServiceHelpMessage();

        } else if (args.length == 1 && args[0].equalsIgnoreCase("info")) {
            Scanner scanner = new Scanner(System.in);

            RCCloud.getConsoleManager().sendMessage("Enter the service to get info: ", MessageType.SAMELINE);
            String serverName = scanner.nextLine();

            CloudAPI.getInformation(serverName);
        }
    }
}
