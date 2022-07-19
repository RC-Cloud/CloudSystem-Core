package de.realzone.cloud.utils;

import de.realzone.cloud.RCCloud;

public class Utils {

    public static String[] dropFirstString(String[] array) {
        String[] strings = new String[array.length - 1];
        System.arraycopy(array, 1, strings, 0, array.length - 1);
        return strings;
    }

    public static void sendHelpMessage(){

        String serviceprefix = Color.BLUE + "service " + Color.RESET;

        RCCloud.getConsoleManager().sendMessage("\n" +
                        serviceprefix + "create {Name} > " + RCCloud.getCloudManager().getProperties().getProperty("service_create") + "\n" +
                        serviceprefix + "delete {Name} > " + RCCloud.getCloudManager().getProperties().getProperty("service_delete") + "\n" +
                        serviceprefix + "stop {Name} > " + RCCloud.getCloudManager().getProperties().getProperty("service_stop") + "\n" +
                        serviceprefix + "start {Name} > " + RCCloud.getCloudManager().getProperties().getProperty("service_start") + "\n" +
                        serviceprefix + "info {Name} > " + RCCloud.getCloudManager().getProperties().getProperty("service_info") + "\n" +
                        serviceprefix + "restart {Name} > " + RCCloud.getCloudManager().getProperties().getProperty("service_restart") + "\n" +
                        serviceprefix + "command {Command} > " + RCCloud.getCloudManager().getProperties().getProperty("service_send_command") + "\n" +
                        serviceprefix + "send {Command} > " + RCCloud.getCloudManager().getProperties().getProperty("service_send_command") + "\n" +
                        serviceprefix + "startall > " + RCCloud.getCloudManager().getProperties().getProperty("service_start_all") + "\n" +
                        serviceprefix + "list > " + RCCloud.getCloudManager().getProperties().getProperty("service_list") + "\n",
                MessageType.NOTHING);
    }
}
