package de.realzone.cloud;

import de.realzone.cloud.command.commands.ShutdownCommand;
import de.realzone.cloud.command.commands.service.ServiceCreateCommand;
import de.realzone.cloud.command.commands.service.ServiceHelpCommand;
import de.realzone.cloud.manager.CloudManager;
import de.realzone.cloud.manager.CommandManager;
import de.realzone.cloud.manager.ConsoleManager;
import de.realzone.cloud.utils.Color;
import de.realzone.cloud.utils.MessageType;
import lombok.Getter;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RCCloud {

    @Getter
    private static ConsoleManager consoleManager;
    @Getter
    private static CommandManager commandManager;
    @Getter
    private static CloudManager cloudManager;

    public static void main(String[] args){

        consoleManager = new ConsoleManager();
        commandManager = new CommandManager();
        cloudManager = new CloudManager();

        getConsoleManager().sendMessage("Loading Cloud...", MessageType.INFO);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        getConsoleManager().sendMessage("" + Color.CYAN +
                "" +
                "                                                             \n" +
                " ██████╗░░█████╗░        ░█████╗░██╗░░░░░░█████╗░██╗░░░██╗██████╗░ \n" +
                " ██╔══██╗██╔══██╗        ██╔══██╗██║░░░░░██╔══██╗██║░░░██║██╔══██╗\n" +
                " ██████╔╝██║░░╚═╝        ██║░░╚═╝██║░░░░░██║░░██║██║░░░██║██║░░██║\n" +
                " ██╔══██╗██║░░██╗        ██║░░██╗██║░░░░░██║░░██║██║░░░██║██║░░██║\n" +
                " ██║░░██║╚█████╔╝        ╚█████╔╝███████╗╚█████╔╝╚██████╔╝██████╔╝\n" +
                " ╚═╝░░╚═╝░╚════╝░        ░╚════╝░╚══════╝░╚════╝░░╚═════╝░╚═════╝░\n" +
                "      -- Developed by RealZone22 & CrafterLP_2K7 --          \n" +
                "                      Version: 1.0                           \n" +
                "", MessageType.NOTHING);
        getConsoleManager().sendMessage("Ready", MessageType.INFO);

        //Call Methods
        getCommandManager().loadCommands();
        getCommandManager().readCommand();
    }
}
