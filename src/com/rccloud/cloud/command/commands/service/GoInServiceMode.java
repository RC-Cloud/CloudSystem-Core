package com.rccloud.cloud.command.commands.service;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.command.Command;
import com.rccloud.cloud.utils.Color;
import com.rccloud.cloud.utils.MessageType;
import com.rccloud.cloud.utils.Utils;

import java.util.Scanner;

public class GoInServiceMode extends Command {

    public GoInServiceMode() {
        super("service");
    }

    @Override
    public void onCommand(String[] args) {
        while (true){
            Scanner scanner = new Scanner(System.in);
            RCCloud.getConsoleManager().sendMessage(Color.BLUE + "Service " + Color.WHITE + "» " + Color.RESET, MessageType.SAMELINE);
            String command = scanner.nextLine();
            String[] commandArgs = command.split(" ");

            if(command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("service")
            || command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("leave")){
                break;

            }
            if(command.equalsIgnoreCase("help")) {
                Utils.sendServiceHelpMessage();

            }
            if(command.equalsIgnoreCase("create")){
                ServiceCreateCommand.onService(commandArgs);

            }
            if(command.equalsIgnoreCase("delete")){
                ServiceDeleteCommand.onService(commandArgs);

            }
            if(command.equalsIgnoreCase("info")){
                ServiceInfoCommand.onService(commandArgs);

            }
            if(command.equalsIgnoreCase("list")){
                ServiceListCommand.onService(commandArgs);

            }
            if(command.equalsIgnoreCase("stop")){
                ServiceStopCommand.onService(commandArgs);

            }
            if(command.equalsIgnoreCase("start")){
                ServiceStartCommand.onService(commandArgs);

            }
            if(command.equalsIgnoreCase("restart")){
                ServiceRestartCommand.onService(commandArgs);

            }
            if(command.equalsIgnoreCase("send")){
                ServiceSendCommand.onService(commandArgs);
            }

            if(command.equalsIgnoreCase("update")){
                ServiceUpdateCommand.onService(commandArgs);
            }
        }
    }
}
