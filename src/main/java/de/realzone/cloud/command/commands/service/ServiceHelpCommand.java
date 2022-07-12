package de.realzone.cloud.command.commands.service;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.command.Command;
import de.realzone.cloud.utils.Color;
import de.realzone.cloud.utils.MessageType;

public class ServiceHelpCommand extends Command {

    public ServiceHelpCommand() {
        super("service");
    }

    private static String serviceprefix = Color.BLUE + "service " + Color.RESET;
    @Override
    public void execute(String[] args) {
        if(args.length == 0 || args[0].equalsIgnoreCase("help")) {
            RCCloud.getConsoleManager().sendMessage("" +
                    serviceprefix + "create {Name} > " + RCCloud.getCloudManager().getProperties().getProperty("service_create") + "\n" +
                    serviceprefix + "delete {Name} > " + RCCloud.getCloudManager().getProperties().getProperty("service_delete") + "\n" +
                    serviceprefix + "stop {Name} > " + RCCloud.getCloudManager().getProperties().getProperty("service_stop") + "\n" +
                    serviceprefix + "start {Name} > " + RCCloud.getCloudManager().getProperties().getProperty("service_start") + "\n" +
                    serviceprefix + "info {Name} > " + RCCloud.getCloudManager().getProperties().getProperty("service_info") + "\n" +
                    serviceprefix + "list > " + RCCloud.getCloudManager().getProperties().getProperty("service_list") + "\n" +
                    serviceprefix + "help > " + RCCloud.getCloudManager().getProperties().getProperty("service_help") + "\n",
                    MessageType.NOTHING);
        }
    }
}
