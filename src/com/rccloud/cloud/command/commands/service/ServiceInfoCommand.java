package com.rccloud.cloud.command.commands.service;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.api.CloudAPI;
import com.rccloud.cloud.utils.MessageType;

import java.util.Scanner;


public class ServiceInfoCommand {

    public static void onService(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("input_server_name"), MessageType.SAMELINE);
        String serverName = scanner.nextLine();

        CloudAPI.getInformation(serverName);

    }
}
