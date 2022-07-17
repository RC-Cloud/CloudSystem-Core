package de.realzone.cloud.command.commands.service;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.api.CloudAPI;
import de.realzone.cloud.command.Command;
import de.realzone.cloud.utils.MessageType;

public class ServiceCreateCommand extends Command {

    public ServiceCreateCommand() {
        super("service");
    }

    @Override
    public void onCommand(String[] args) {

        if(args.length == 1 && args[0].equalsIgnoreCase("create")){
            RCCloud.getConsoleManager().sendMessage("test", MessageType.INFO);

            //TODO: Create Service use CommandManager Class for Reading answers && Jar Releaser
        }
    }
}
