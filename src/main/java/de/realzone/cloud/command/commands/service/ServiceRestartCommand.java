package de.realzone.cloud.command.commands.service;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.api.CloudAPI;
import de.realzone.cloud.command.Command;
import de.realzone.cloud.utils.MessageType;
import de.realzone.cloud.utils.Utils;

import java.util.Scanner;

public class ServiceRestartCommand {//TODO Screen implementation

    public static void onService(String[] args) {

        if(args.length == 0){
            Utils.sendServiceHelpMessage();

        }else if(args[0].equalsIgnoreCase("restart")){
            Scanner scanner = new Scanner(System.in);

            RCCloud.getConsoleManager().sendMessage("Enter the name of the service you want to restart: ", MessageType.SAMELINE);
            String server = scanner.nextLine();

            CloudAPI.startServer(server);
        }

    }
}
