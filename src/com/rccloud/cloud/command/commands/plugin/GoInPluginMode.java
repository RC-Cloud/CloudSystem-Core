package com.rccloud.cloud.command.commands.plugin;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.command.Command;
import com.rccloud.cloud.utils.Color;
import com.rccloud.cloud.utils.MessageType;
import com.rccloud.cloud.utils.Utils;

import java.util.Scanner;

public class GoInPluginMode extends Command {

    public GoInPluginMode() {
        super("plugin");
    }

    @Override
    public void onCommand(String[] args) {
        while (true){
            Scanner scanner = new Scanner(System.in);

            RCCloud.getConsoleManager().sendMessage(Color.BLUE + "Plugin " + Color.WHITE + "» " + Color.RESET, MessageType.SAMELINE);
            String command = scanner.nextLine();
            String[] commandArgs = command.split(" ");

            if(command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("plugin")
                || command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("leave")){
                break;

            }else if(command.equalsIgnoreCase("help")) {
                Utils.sendPluginHelpMessage();

            }else if(command.equalsIgnoreCase("download")){
                DownloadPluginCommand.onPlugin(commandArgs);

            }else if(command.equalsIgnoreCase("move")){
                MovePluginCommand.onPlugin(commandArgs);

            }else if(command.equalsIgnoreCase("delete")){
                DeletePluginCommand.onPlugin(commandArgs);

            }else if(command.equalsIgnoreCase("list")){
                PluginListCommand.onPlugin(commandArgs);
            }
        }
    }

}
