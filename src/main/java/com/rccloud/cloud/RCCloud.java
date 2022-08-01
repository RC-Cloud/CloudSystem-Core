package com.rccloud.cloud;

import com.rccloud.cloud.manager.CommandManager;
import com.rccloud.cloud.manager.ConsoleManager;
import com.rccloud.cloud.manager.SetupManager;
import com.rccloud.cloud.utils.MessageType;
import com.rccloud.cloud.manager.CloudManager;
import com.rccloud.cloud.utils.Color;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RCCloud {

    @Getter
    private static ConsoleManager consoleManager;
    @Getter
    private static CommandManager commandManager;
    @Getter
    private static CloudManager cloudManager;
    @Getter
    private static SetupManager setupManager;

    public static void main(String[] args){

        consoleManager = new ConsoleManager();
        commandManager = new CommandManager();
        cloudManager = new CloudManager();
        setupManager = new SetupManager();

        getConsoleManager().sendMessage("Loading Cloud...", MessageType.INFO);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File setupFile = new File("/home/cloud/setup/", "INSTALLED");
        File finishedFile = new File("/home/cloud/setup/", "FINISHED");
        if(setupFile.exists() && finishedFile.exists()){
            getConsoleManager().sendMessage("Install file found, loading Cloud...", MessageType.INFO);
        }else{
            getConsoleManager().sendMessage("Install file not found, Starting setup...", MessageType.INFO);
            try {
                setupFile.getParentFile().mkdirs();
                setupFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            setupManager.startSetup();
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
                "                      Version: 2.0                           \n" +
                "", MessageType.NOTHING);
        getConsoleManager().sendMessage("Ready", MessageType.INFO);

        //Call Methods
        getCommandManager().loadCommands();
        getCommandManager().readCommand();
    }
}
