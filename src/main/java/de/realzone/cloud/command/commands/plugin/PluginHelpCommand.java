package de.realzone.cloud.command.commands.plugin;

import de.realzone.cloud.command.Command;
import de.realzone.cloud.utils.Color;

public class PluginHelpCommand extends Command {

    public PluginHelpCommand() {
        super("plugin");
    }

    @Override
    public void onCommand(String[] args) {

        if(args.length == 0){
            help();
        }
    }

    public static void help(){
        System.out.println(" ");
        System.out.println(Color.CYAN + "Plugin Command Help");
        System.out.println(" ");
        System.out.println(Color.CYAN + "plugin help" + Color.RESET + " - Shows you this help");
        System.out.println(Color.CYAN + "plugin list" + Color.RESET + " - Shows you all available plugins");
        System.out.println(Color.CYAN + "plugin download <pluginname>" + Color.RESET + " - Downloads the plugin");
        System.out.println(Color.CYAN + "plugin info <pluginname>" + Color.RESET + " - Shows you informations about the plugin");
        System.out.println(" ");
    }
}
