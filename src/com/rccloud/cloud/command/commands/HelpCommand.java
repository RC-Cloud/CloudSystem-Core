package com.rccloud.cloud.command.commands;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.command.Command;
import com.rccloud.cloud.utils.MessageType;
import com.rccloud.cloud.utils.Utils;

public class HelpCommand extends Command {

    public HelpCommand() {
        super("help");
    }

    @Override
    public void onCommand(String[] args) {
        RCCloud.getConsoleManager().sendMessage(" ", MessageType.NOTHING);
        Utils.sendHelpMessage();
    }
}
