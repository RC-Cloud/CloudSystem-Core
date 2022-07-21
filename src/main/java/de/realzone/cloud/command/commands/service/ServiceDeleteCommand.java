package de.realzone.cloud.command.commands.service;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.api.CloudAPI;
import de.realzone.cloud.command.Command;
import de.realzone.cloud.utils.MessageType;

import java.util.Scanner;

import static de.realzone.cloud.utils.Utils.sendServiceHelpMessage;

public class ServiceDeleteCommand {

    public static void onService(String[] args) {

        if (args.length == 0) {
            sendServiceHelpMessage();

        } else if (args[0].equalsIgnoreCase("delete")) {
            Scanner scanner = new Scanner(System.in);

            RCCloud.getConsoleManager().sendMessage("Enter the service to delete: ", MessageType.SAMELINE);
            String serverName = scanner.nextLine();

            RCCloud.getConsoleManager().sendMessage("Are you sure you want to delete the service " + serverName + "? (y/n)", MessageType.SAMELINE);
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                CloudAPI.deleteServer(serverName);
            }else if (answer.equalsIgnoreCase("n")) {
                RCCloud.getConsoleManager().sendMessage("Cancelled", MessageType.INFO);
                return;
            }else{
                RCCloud.getConsoleManager().sendMessage("Cancelled", MessageType.INFO);
                return;
            }
        }

    }
}
