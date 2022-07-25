package com.rccloud.cloud.command.commands.plugin;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.api.utils.APIUtils;
import com.rccloud.cloud.utils.MessageType;

import java.util.Scanner;

public class DeletePluginCommand {

    public static void onPlugin(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("input_server_name"), MessageType.SAMELINE);
        String serverName = scanner.nextLine();

        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("delete_which_plugin"), MessageType.SAMELINE);
        String pluginName = scanner.nextLine();

        APIUtils.deleteFile("/home/servers/" + serverName + "/plugins", pluginName + ".jar");
        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("delete_plugin_success"), MessageType.INFO);

    }
}

