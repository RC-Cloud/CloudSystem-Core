package de.realzone.cloud.command.commands.service;

import de.realzone.cloud.api.utils.APIUtils;
import de.realzone.cloud.command.Command;
import de.realzone.cloud.utils.Utils;

public class ServiceListCommand {

    public static void onService(String[] args) {

        if(args.length == 0){
            Utils.sendServiceHelpMessage();
        } else if (args[0].equalsIgnoreCase("list")) {
            APIUtils.listServers();
        }

    }
}
