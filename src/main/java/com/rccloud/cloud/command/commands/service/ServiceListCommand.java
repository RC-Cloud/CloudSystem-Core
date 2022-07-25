package com.rccloud.cloud.command.commands.service;

import com.rccloud.cloud.api.utils.APIUtils;
import lombok.SneakyThrows;

import java.net.InetAddress;

public class ServiceListCommand {

    @SneakyThrows
    public static void onService(String[] args) {
        APIUtils.listServers();


    }
}
