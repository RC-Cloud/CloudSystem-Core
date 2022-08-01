package com.rccloud.cloud.command.commands.screen;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.api.CloudAPI;
import com.rccloud.cloud.api.utils.APIUtils;
import com.rccloud.cloud.utils.MessageType;

import java.util.Scanner;

public class IntoScreenCommand {

    public static void onScreen(String[] args){
        Scanner scanner = new Scanner(System.in);
        String server = scanner.nextLine();

        if(CloudAPI.isServerOnline(server)){
            APIUtils.runCommand("screen -x " + server);
        }else{
            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("server_not_online"), MessageType.INFO);
        }

    }
}
