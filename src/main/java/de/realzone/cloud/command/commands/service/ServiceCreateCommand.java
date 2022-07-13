package de.realzone.cloud.command.commands.service;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.api.TerminalReader;
import de.realzone.cloud.command.Command;
import de.realzone.cloud.utils.Color;
import de.realzone.cloud.utils.MessageType;
import org.jline.reader.LineReader;

import java.util.Arrays;

public class ServiceCreateCommand extends Command {

    public ServiceCreateCommand() {
        super("service");
    }

    @Override
    public void execute(String[] args) {

        if(args.length == 1 && args[0].equalsIgnoreCase("create")){
            RCCloud.getConsoleManager().sendMessage("test", MessageType.INFO);

            //TODO: Create Service use CommandManager Class for Reading answers && Jar Releaser
            if(TerminalReader.createAndReadLine("test > ", "test", 0)){
                RCCloud.getConsoleManager().sendMessage("Ok", MessageType.INFO);
            }
        }
    }
}
