package com.rccloud.cloud.command.commands.plugin;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.api.enums.Plugins;
import com.rccloud.cloud.api.utils.APIUtils;
import com.rccloud.cloud.utils.MessageType;

import java.util.Scanner;

public class DownloadPluginCommand {

    public static void onPlugin(String[] args) {

            Scanner scanner = new Scanner(System.in);
            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("input_server_name"), MessageType.SAMELINE);
            String serverName = scanner.nextLine();

            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("list_plugins"), MessageType.INFO);
            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("input_plugin_name"), MessageType.SAMELINE);
            String pluginName = scanner.nextLine();

            if(pluginName.equalsIgnoreCase("Luckperms")){
                APIUtils.installPlugins(serverName, Plugins.LUCKPERMS);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if(pluginName.equalsIgnoreCase("PermissionsEx") || pluginName.equalsIgnoreCase("Pex")){
                APIUtils.installPlugins(serverName, Plugins.PEX);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if (pluginName.equalsIgnoreCase("Tab")){
                APIUtils.installPlugins(serverName, Plugins.TAB);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if(pluginName.equalsIgnoreCase("Vault")){
                APIUtils.installPlugins(serverName, Plugins.VAULT);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if(pluginName.equalsIgnoreCase("Essentials")){
                APIUtils.installPlugins(serverName, Plugins.ESSENTIALSX);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if(pluginName.equalsIgnoreCase("WorldEdit")){
                APIUtils.installPlugins(serverName, Plugins.WORLDEDIT);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if(pluginName.equalsIgnoreCase("WorldGuard")){
                APIUtils.installPlugins(serverName, Plugins.WORLDGUARD);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if(pluginName.equalsIgnoreCase("Maintenance")){
                APIUtils.installPlugins(serverName, Plugins.MAINTENANCE);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if(pluginName.equalsIgnoreCase("ProtocolLib")){
                APIUtils.installPlugins(serverName, Plugins.PROTOCOLLIB);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if (pluginName.equalsIgnoreCase("ViaVersion")){
                APIUtils.installPlugins(serverName, Plugins.VIAVERSION);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("plugin_installed"), MessageType.INFO);

            }else if (pluginName.equalsIgnoreCase("ViaBackwards")){
                APIUtils.installPlugins(serverName, Plugins.VIABACKWARDS);
                RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("plugin_installed"), MessageType.INFO);

        }
    }
}
