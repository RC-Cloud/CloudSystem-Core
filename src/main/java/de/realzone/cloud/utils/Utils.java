package de.realzone.cloud.utils;

import de.realzone.cloud.RCCloud;

public class Utils {

    public static String[] dropFirstString(String[] array) {
        String[] strings = new String[array.length - 1];
        System.arraycopy(array, 1, strings, 0, array.length - 1);
        return strings;
    }

    public static void sendServiceHelpMessage(){

        String serviceprefix = Color.BLUE + "service " + Color.RESET;

        RCCloud.getConsoleManager().sendMessage("\n" +
                        serviceprefix + "command {Command} > " + RCCloud.getCloudManager().getProperties().getProperty("service_send_command") + "\n" +
                        serviceprefix + "send {Command} > " + RCCloud.getCloudManager().getProperties().getProperty("service_send_command") + "\n" +
                        serviceprefix + "create > " + RCCloud.getCloudManager().getProperties().getProperty("service_create") + "\n" +
                        serviceprefix + "delete > " + RCCloud.getCloudManager().getProperties().getProperty("service_delete") + "\n" +
                        serviceprefix + "stop > " + RCCloud.getCloudManager().getProperties().getProperty("service_stop") + "\n" +
                        serviceprefix + "start > " + RCCloud.getCloudManager().getProperties().getProperty("service_start") + "\n" +
                        serviceprefix + "info > " + RCCloud.getCloudManager().getProperties().getProperty("service_info") + "\n" +
                        serviceprefix + "restart > " + RCCloud.getCloudManager().getProperties().getProperty("service_restart") + "\n" +
                        serviceprefix + "startall > " + RCCloud.getCloudManager().getProperties().getProperty("service_start_all") + "\n" +
                        serviceprefix + "list > " + RCCloud.getCloudManager().getProperties().getProperty("service_list") + "\n",
                MessageType.NOTHING);
    }
}
