package com.rccloud.cloud.command.commands.screen;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.api.utils.APIUtils;
import com.rccloud.cloud.utils.MessageType;

import java.util.Scanner;

public class ScreenViewCommand {

    public static void onScreen(String[] args){
        Scanner scanner = new Scanner(System.in);
        String server = scanner.nextLine();

        APIUtils.runCommand("screen -x " + server);
        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("all_screen_stopped"), MessageType.SAMELINE); //TODO Translations
    }
}