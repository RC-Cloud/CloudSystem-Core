package de.realzone.cloud.command.commands.service;

import de.realzone.cloud.command.Command;

import java.util.Scanner;

import static de.realzone.cloud.utils.Utils.sendHelpMessage;

public class ServiceDeleteCommand extends Command {

    public ServiceDeleteCommand() {
        super("service");
    }

    @Override
    public void onCommand(String[] args) {

        if(args.length == 0){
            sendHelpMessage();
        }

        if(args.length == 1 && args[0].equalsIgnoreCase("delete")){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of the service to delete: ");
            String serviceName = scanner.nextLine();
            System.out.println("Are you sure you want to delete the service " + serviceName + "? (y/n)");
            String answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("y")){
                System.out.println("Deleting service " + serviceName);
            }
        }

    }
}
