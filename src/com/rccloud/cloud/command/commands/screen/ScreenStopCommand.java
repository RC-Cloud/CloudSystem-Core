package com.rccloud.cloud.command.commands.screen;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.api.CloudAPI;
import com.rccloud.cloud.utils.MessageType;

import java.util.Scanner;

public class ScreenStopCommand {

    public static void onScreen(String[] args){
        Scanner scanner = new Scanner(System.in);

        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("input_server_name"), MessageType.SAMELINE);
        String server = scanner.nextLine();
        if(CloudAPI.isServerOnline(server)) {
            CloudAPI.stopServer(server);
            return;
        }else{
            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("server_not_online"), MessageType.SAMELINE);
        }
    }
}
