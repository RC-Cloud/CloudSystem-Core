package de.realzone.cloud;

import de.realzone.cloud.command.commands.ShutdownCommand;
import de.realzone.cloud.command.commands.service.ServiceHelpCommand;
import de.realzone.cloud.manager.CloudManager;
import de.realzone.cloud.manager.CommandManager;
import de.realzone.cloud.manager.ConsoleManager;
import de.realzone.cloud.utils.Color;
import de.realzone.cloud.utils.MessageType;
import lombok.Getter;

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
        registerCommands();

        Thread commandSystem = new Thread(getCommandManager().reading(), "COMMAND");
        commandSystem.start();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                getConsoleManager().sendMessage(" ", MessageType.NOTHING);
                getConsoleManager().sendMessage(getCloudManager().getProperties().get("cloud_shutdown").toString(), MessageType.INFO);

            }
        }));
    }

    private static void registerCommands(){
        RCCloud.getCommandManager().registerCommand(new ServiceHelpCommand());
        RCCloud.getCommandManager().registerCommand(new ShutdownCommand());
    }
}
