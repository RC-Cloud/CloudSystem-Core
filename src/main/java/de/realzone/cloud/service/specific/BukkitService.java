package de.realzone.cloud.service.specific;

import de.realzone.cloud.service.Service;
import lombok.Getter;

import java.util.UUID;

@Getter
public class BukkitService extends Service {
    private final int maxplayers;


    public BukkitService(UUID id, int port, int ram, String group, boolean dynamic, int maxplayers) {
        super(id, port, ram, group, dynamic);
        this.maxplayers = maxplayers;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void create() {

    }
}
