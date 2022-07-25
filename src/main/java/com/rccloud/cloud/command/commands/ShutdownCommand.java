package com.rccloud.cloud.command.commands;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.command.Command;
import com.rccloud.cloud.utils.MessageType;

public class ShutdownCommand extends Command {

    public ShutdownCommand() {
        super("shutdown");
    }

    @Override
    public void onCommand(String[] args) {

        if(args.length == 0){
            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("cloud_shutdown_confirm"), MessageType.INFO);

        }else if(args.length == 1 && args[0].equalsIgnoreCase("confirm")){
            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("cloud_shutdown"), MessageType.INFO);
            System.exit(0);
        }
    }
}
