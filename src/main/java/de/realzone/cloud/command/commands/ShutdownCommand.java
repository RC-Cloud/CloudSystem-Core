package de.realzone.cloud.command.commands;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.command.Command;
import de.realzone.cloud.manager.ConsoleManager;
import de.realzone.cloud.utils.MessageType;

public class ShutdownCommand extends Command {

    public ShutdownCommand() {
        super("shutdown", "exit", "stop");
    }

    @Override
    public void execute(String[] args) {

        if(args.length == 0){
            RCCloud.getConsoleManager().sendMessage("Please use 'shutdown confirm' to stop the Cloud", MessageType.INFO);

        }else if(args.length == 1 && args[0].equalsIgnoreCase("confirm")){
            System.exit(0);
        }
    }
}
