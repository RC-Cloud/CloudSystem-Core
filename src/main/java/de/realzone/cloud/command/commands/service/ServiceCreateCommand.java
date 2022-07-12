package de.realzone.cloud.command.commands.service;

import de.realzone.cloud.command.Command;

public class ServiceCreateCommand extends Command {

    public ServiceCreateCommand() {
        super("service");
    }

    @Override
    public void execute(String[] args) {

        if(args.length == 1 && args[0].equalsIgnoreCase("create")){
            //TODO: Create Service use CommandManager Class for Reading answers
        }
    }
}
