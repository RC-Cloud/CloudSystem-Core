package com.rccloud.cloud.utils;

import com.rccloud.cloud.RCCloud;

public class Utils {

    public static String[] dropFirstString(String[] array) {
        String[] strings = new String[array.length - 1];
        System.arraycopy(array, 1, strings, 0, array.length - 1);
        return strings;
    }

    public static void sendServiceHelpMessage(){

        RCCloud.getConsoleManager().sendMessage("\n" +
                        "help > " + RCCloud.getCloudManager().getLangProperties().getProperty("help") + "\n" +
                        "send > " + RCCloud.getCloudManager().getLangProperties().getProperty("service_send_command") + "\n" +
                        "create > " + RCCloud.getCloudManager().getLangProperties().getProperty("service_create") + "\n" +
                        "delete > " + RCCloud.getCloudManager().getLangProperties().getProperty("service_delete") + "\n" +
                        "stop > " + RCCloud.getCloudManager().getLangProperties().getProperty("service_stop") + "\n" +
                        "start > " + RCCloud.getCloudManager().getLangProperties().getProperty("service_start") + "\n" +
                        "info > " + RCCloud.getCloudManager().getLangProperties().getProperty("service_info") + "\n" +
                        "restart > " + RCCloud.getCloudManager().getLangProperties().getProperty("service_restart") + "\n" +
                        "update > " + RCCloud.getCloudManager().getLangProperties().getProperty("service_update") + "\n" +
                        "startall (Comming Soon) > " + RCCloud.getCloudManager().getLangProperties().getProperty("service_start_all") + "\n" +
                        "list > " + RCCloud.getCloudManager().getLangProperties().getProperty("service_list") + "\n",
                MessageType.NOTHING);
    }

    public static void sendPluginHelpMessage(){

        RCCloud.getConsoleManager().sendMessage("\n" +
                        "download > " + RCCloud.getCloudManager().getLangProperties().getProperty("plugin_download") + "\n" +
                        "delete > " + RCCloud.getCloudManager().getLangProperties().getProperty("plugin_delete") + "\n" +
                        "list > " + RCCloud.getCloudManager().getLangProperties().getProperty("plugin_list") + "\n" +
                        "list > " + RCCloud.getCloudManager().getLangProperties().getProperty("help") + "\n" +
                        "move > " + RCCloud.getCloudManager().getLangProperties().getProperty("plugin_move") + "\n",
                MessageType.NOTHING);
    }

    public static void sendScreenHelpMessage(){

        RCCloud.getConsoleManager().sendMessage("\n" +
                        "list > " + RCCloud.getCloudManager().getLangProperties().getProperty("screen_list") + "\n" +
                        "stopAll > " + RCCloud.getCloudManager().getLangProperties().getProperty("screen_stopall") + "\n" +
                        "killAll > " + RCCloud.getCloudManager().getLangProperties().getProperty("screen_killall") + "\n" +
                        "write > " + RCCloud.getCloudManager().getLangProperties().getProperty("screen_write") + "\n" +
                        "start > " + RCCloud.getCloudManager().getLangProperties().getProperty("screen_start") + "\n" +
                        "stop > " + RCCloud.getCloudManager().getLangProperties().getProperty("screen_stop") + "\n" +
                        "goin > " + RCCloud.getCloudManager().getLangProperties().getProperty("screen_goin") + "\n" +
                        "view > " + RCCloud.getCloudManager().getLangProperties().getProperty("screen_view") + "\n",
                MessageType.NOTHING);
    }
}
