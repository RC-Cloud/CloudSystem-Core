package com.rccloud.cloud.command.commands.screen;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.api.utils.APIUtils;
import com.rccloud.cloud.utils.MessageType;

public class ScreenKillAllCommand {

    public static void onScreen(String[] args){
        APIUtils.runCommand("pkill screen");
        RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("all_screen_stopped"), MessageType.SAMELINE); //TODO Translations
    }
}
