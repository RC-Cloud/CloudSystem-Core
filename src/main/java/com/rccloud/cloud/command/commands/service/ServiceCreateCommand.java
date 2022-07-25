package com.rccloud.cloud.command.commands.service;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.api.utils.APIUtils;
import com.rccloud.cloud.api.utils.DownloadSoftware;
import com.rccloud.cloud.utils.MessageType;
import com.rccloud.cloud.api.enums.ServerType;

import java.util.Scanner;

public class ServiceCreateCommand {

    public static void onService(String[] args) {

            Scanner scanner = new Scanner(System.in);

            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("service_create_name"), MessageType.SAMELINE);
            String serviceName = scanner.nextLine();

            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("service_create_type"), MessageType.SAMELINE);
            String serverSoftware = scanner.nextLine();
            if (serverSoftware.equalsIgnoreCase("Paper") || serverSoftware.equalsIgnoreCase("Spigot")) {
                //Server Software is valid
            } else if (serverSoftware.equalsIgnoreCase("BungeeCord")) {

                //BungeeCord start
                try {
                    RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("service_create_ram"), MessageType.SAMELINE);
                    int ram = Integer.parseInt(scanner.nextLine());

                    RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("service_create_port"), MessageType.SAMELINE);
                    int port = Integer.parseInt(scanner.nextLine());

                    RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("service_bungee_minecraft_username"), MessageType.SAMELINE);
                    String username = scanner.nextLine();

                    APIUtils.createBungeeConfig(serviceName, port, username);
                    APIUtils.createStartFile(serviceName, ServerType.BUNGEECORD, ram);
                    APIUtils.createJsonFile(serviceName, "1.19", ServerType.BUNGEECORD, ram, port);

                } catch (NumberFormatException e) {
                    RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("invalid_number"), MessageType.ERROR);
                    return;
                }

                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("downloading_bungeecord"), MessageType.INFO);
                DownloadSoftware.downloadSoftwareBungeeCord();
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("finished_downloading_bungeecord"), MessageType.INFO);
                APIUtils.moveToServerDirectory(serviceName, "bungeecord.jar");

                return;
            } else {
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("invalid_server_software"), MessageType.ERROR);
                return;
            }
            //BungeeCord end

            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("service_create_version"), MessageType.SAMELINE);
            String serverVersion = scanner.nextLine();
            if (serverVersion.equalsIgnoreCase("1.19") || serverVersion.equalsIgnoreCase("1.18")
                    || serverVersion.equalsIgnoreCase("1.17") || serverVersion.equalsIgnoreCase("1.16")
                    || serverVersion.equalsIgnoreCase("1.15") || serverVersion.equalsIgnoreCase("1.14")
                    || serverVersion.equalsIgnoreCase("1.13") || serverVersion.equalsIgnoreCase("1.12")
                    || serverVersion.equalsIgnoreCase("1.11") || serverVersion.equalsIgnoreCase("1.10")
                    || serverVersion.equalsIgnoreCase("1.9") || serverVersion.equalsIgnoreCase("1.8")) {
                //Version is valid
            } else {
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("invalid_server_version"), MessageType.ERROR);
                return;
            }

            try {
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("service_create_ram"), MessageType.SAMELINE);
                int ram = Integer.parseInt(scanner.nextLine());

                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("service_create_port"), MessageType.SAMELINE);
                int port = Integer.parseInt(scanner.nextLine());

                if (serverSoftware.equalsIgnoreCase("Paper")) {
                    APIUtils.createStartFile(serviceName, ServerType.PAPER, ram);
                    APIUtils.createJsonFile(serviceName, serverVersion, ServerType.PAPER, ram, port);
                    RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("downloading_paper"), MessageType.INFO);

                    DownloadSoftware.downloadSoftwarePaper(serverVersion);
                    APIUtils.moveToServerDirectory(serviceName, "paper.jar");

                } else if (serverSoftware.equalsIgnoreCase("Spigot")) {
                    APIUtils.createStartFile(serviceName, ServerType.SPIGOT, ram);
                    APIUtils.createJsonFile(serviceName, serverVersion, ServerType.SPIGOT, ram, port);
                    RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("downloading_spigot"), MessageType.INFO);
                    DownloadSoftware.downloadSoftwareSpigot(serverVersion);
                    APIUtils.moveToServerDirectory(serviceName, "spigot.jar");
                }

                APIUtils.createServerProperties(serviceName, port);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("finished_downloading"), MessageType.INFO);
            } catch (NumberFormatException e) {
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("invalid_number"), MessageType.ERROR);
                return;
            }
            APIUtils.createEula(serviceName);
            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("service_created"), MessageType.INFO);
    }
}
