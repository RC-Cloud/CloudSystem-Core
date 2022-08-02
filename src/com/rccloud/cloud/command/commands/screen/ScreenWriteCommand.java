package com.rccloud.cloud.command.commands.screen;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.api.utils.APIUtils;
import com.rccloud.cloud.utils.MessageType;

import java.util.Scanner;

public class ScreenWriteCommand {

    public static void onScreen(String[] args){
        Scanner scanner = new Scanner(System.in);
        String server = scanner.nextLine();

        String command = scanner.nextLine();
        APIUtils.runCommandToServer(server, command);
        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("command_sent"), MessageType.INFO);
    }
}
