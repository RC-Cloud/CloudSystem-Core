package com.rccloud.cloud.command.commands.screen;

import com.rccloud.cloud.api.utils.APIUtils;

import java.util.Scanner;

public class ScreenWriteCommand {

    public static void onScreen(String[] args){
        Scanner scanner = new Scanner(System.in);
        String server = scanner.nextLine();

        String command = scanner.nextLine();
        APIUtils.runCommandToServer(server, command);

    }
}
