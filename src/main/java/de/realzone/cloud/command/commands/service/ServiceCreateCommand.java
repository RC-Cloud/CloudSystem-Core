package de.realzone.cloud.command.commands.service;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.api.enums.ServerType;
import de.realzone.cloud.api.utils.APIUtils;
import de.realzone.cloud.api.utils.DownloadSoftware;
import de.realzone.cloud.command.Command;
import de.realzone.cloud.utils.MessageType;

import java.util.Scanner;

import static de.realzone.cloud.utils.Utils.sendHelpMessage;

public class ServiceCreateCommand extends Command {

    public ServiceCreateCommand() {
        super("service");
    }

    @Override
    public void onCommand(String[] args) {

        if(args.length == 0){
            sendHelpMessage();
        }

        if(args.length == 1 && args[0].equalsIgnoreCase("create")){
            Scanner scanner = new Scanner(System.in); //Todo create Cloud.json file, create Server

            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("service_create_name"), MessageType.SAMELINE);
            String serviceName = scanner.nextLine();

            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("service_create_type"), MessageType.SAMELINE);
            String serverSoftware = scanner.nextLine();
            if(serverSoftware.equalsIgnoreCase("Paper") || serverSoftware.equalsIgnoreCase("Spigot")){
                //Server Software is valid
            }else if (serverSoftware.equalsIgnoreCase("BungeeCord")){

                //BungeeCord start
                try {
                    RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("service_create_ram"), MessageType.SAMELINE);
                    int ram = Integer.parseInt(scanner.nextLine());

                    RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("service_create_port"), MessageType.SAMELINE);
                    int port = Integer.parseInt(scanner.nextLine());

                    APIUtils.createStartFile(serviceName, ServerType.BUNGEECORD, ram);
                    APIUtils.createJsonFile(serviceName, "1.19", ServerType.BUNGEECORD, ram, port);

                }catch (NumberFormatException e){
                    RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("invalid_number"), MessageType.ERROR);
                    return;
                }

                RCCloud.getConsoleManager().sendMessage("Downloading BungeeCord...", MessageType.INFO);
                DownloadSoftware.downloadSoftwareBungeeCord();
                RCCloud.getConsoleManager().sendMessage("BungeeCord downloaded.", MessageType.INFO);
                APIUtils.moveToServerDirectory(serviceName, "bungeecord.jar");

                return;
            }else{
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("invalid_server_software"), MessageType.ERROR);
                return;
            }
            //BungeeCord end

            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("service_create_version"), MessageType.SAMELINE);
            String serverVersion = scanner.nextLine();
            if (serverVersion.equalsIgnoreCase("1.19") || serverVersion.equalsIgnoreCase("1.18")
                    || serverVersion.equalsIgnoreCase("1.17") || serverVersion.equalsIgnoreCase("1.16")
                    || serverVersion.equalsIgnoreCase("1.15") || serverVersion.equalsIgnoreCase("1.14")
                    || serverVersion.equalsIgnoreCase("1.13") || serverVersion.equalsIgnoreCase("1.12")
                    || serverVersion.equalsIgnoreCase("1.11") || serverVersion.equalsIgnoreCase("1.10")
                    || serverVersion.equalsIgnoreCase("1.9")  || serverVersion.equalsIgnoreCase("1.8")){
                //Version is valid
            }else{
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("invalid_server_version"), MessageType.ERROR);
                return;
            }

            try {
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("service_create_ram"), MessageType.SAMELINE);
                int ram = Integer.parseInt(scanner.nextLine());

                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("service_create_port"), MessageType.SAMELINE);
                int port = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("invalid_number"), MessageType.ERROR);
                return;
            }
        }
    }
}
