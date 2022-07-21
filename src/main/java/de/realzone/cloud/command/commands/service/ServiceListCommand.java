package de.realzone.cloud.command.commands.service;

import de.realzone.cloud.api.utils.APIUtils;

public class ServiceListCommand {

    public static void onService(String[] args) {

        APIUtils.listServers();


    }
}
