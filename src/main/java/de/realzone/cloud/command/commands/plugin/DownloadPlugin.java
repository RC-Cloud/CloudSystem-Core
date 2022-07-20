package de.realzone.cloud.command.commands.plugin;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.api.enums.Plugins;
import de.realzone.cloud.api.utils.APIUtils;
import de.realzone.cloud.command.Command;
import de.realzone.cloud.utils.MessageType;

import java.util.Scanner;

public class DownloadPlugin extends Command {

    public DownloadPlugin() {
        super("plugin");
    }

    @Override
    public void onCommand(String[] args) {
        if(args.length == 0){
            PluginHelpCommand.help();
        } else if (args[0].equalsIgnoreCase("download")) {

            Scanner scanner = new Scanner(System.in);
            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("input_server_name"), MessageType.SAMELINE);
            String serverName = scanner.nextLine();

            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("list_plugins"), MessageType.INFO);
            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("input_plugin_name"), MessageType.SAMELINE);
            String pluginName = scanner.nextLine();

            if(pluginName.equalsIgnoreCase("Luckperms")){
                APIUtils.installPlugins(serverName, Plugins.LUCKPERMS);
                RCCloud.getConsoleManager().sendMessage("LuckPerms installed!", MessageType.INFO);

            }else if(pluginName.equalsIgnoreCase("PermissionsEx") || pluginName.equalsIgnoreCase("Pex")){
                APIUtils.installPlugins(serverName, Plugins.PEX);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if (pluginName.equalsIgnoreCase("Tab")){
                APIUtils.installPlugins(serverName, Plugins.TAB);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if(pluginName.equalsIgnoreCase("Vault")){
                APIUtils.installPlugins(serverName, Plugins.VAULT);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if(pluginName.equalsIgnoreCase("Essentials")){
                APIUtils.installPlugins(serverName, Plugins.ESSENTIALSX);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if(pluginName.equalsIgnoreCase("WorldEdit")){
                APIUtils.installPlugins(serverName, Plugins.WORLDEDIT);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if(pluginName.equalsIgnoreCase("WorldGuard")){
                APIUtils.installPlugins(serverName, Plugins.WORLDGUARD);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if(pluginName.equalsIgnoreCase("Maintenance")){
                APIUtils.installPlugins(serverName, Plugins.MAINTENANCE);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if(pluginName.equalsIgnoreCase("ProtocolLib")){
                APIUtils.installPlugins(serverName, Plugins.PROTOCOLLIB);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if (pluginName.equalsIgnoreCase("ViaVersion")){
                APIUtils.installPlugins(serverName, Plugins.VIAVERSION);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if (pluginName.equalsIgnoreCase("ViaBackwards")){
                APIUtils.installPlugins(serverName, Plugins.VIABACKWARDS);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getProperties().getProperty("plugin_installed"), MessageType.INFO);

            }
        }
    }
}
