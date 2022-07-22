package de.realzone.cloud.command.commands.plugin;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.api.utils.APIUtils;
import de.realzone.cloud.utils.MessageType;

import java.util.Scanner;

public class MovePluginCommand  {

    public static void onPlugin(String[] args) {


        Scanner scanner = new Scanner(System.in);
        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("input_server_name"), MessageType.SAMELINE);
        String serverName = scanner.nextLine();

        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("move_plugin_which_plugin"), MessageType.SAMELINE);
        String pluginName = scanner.nextLine();

        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("move_plugin_to_which_service"), MessageType.SAMELINE);
        String targetServerName = scanner.nextLine();

        APIUtils.movePlugin(serverName, targetServerName, pluginName + ".jar");
        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("move_plugin_success"), MessageType.INFO);


    }
}
