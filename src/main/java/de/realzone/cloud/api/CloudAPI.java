package de.realzone.cloud.api;

import de.realzone.cloud.api.enums.ServerType;
import de.realzone.cloud.api.utils.DownloadSoftware;

public class CloudAPI {

    public static void createServer(String serverName, String version, ServerType serverType, int ram, int port) {
        switch (serverType) {
            case BUNGEECORD:
                DownloadSoftware.downloadSoftwareBungeeCord();
                break;

            case PAPER:
                DownloadSoftware.downloadSoftwarePaper(version);
                break;

            case SPIGOT:
                DownloadSoftware.downloadSoftwareSpigot(version);
                break;
        }
    }

    public static void deleteServer(String serverName) {

    }

    public static void changeVersion(ServerType serverType, String serverName, String version) {

        //TODO remove old files
        switch (serverType) {
            case BUNGEECORD:
                DownloadSoftware.downloadSoftwareBungeeCord();
                break;

            case PAPER:
                DownloadSoftware.downloadSoftwarePaper(version);
                break;

            case SPIGOT:
                DownloadSoftware.downloadSoftwareSpigot(version);
                break;
        }
    }

    public static void changeServerSoftware(String serverName, ServerType serverType) {

    }

    public static void changeName(String serverName, String newName) {

    }

    public static void changeRam(int ram) {

    }

    public static void changePort(int port) {

    }

    public static void startServer(String serverName) {

    }

    public static void stopServer(String serverName) {

    }

    public static boolean isServerOnline(String serverName) {
        return false; /* TODO Add Online Support */
    }

    public static void connectToServer(String serverName) {

    }

    public static void sendCommand(String serverName) {

    }

    private static void downloadSoftware(ServerType serverType, String version){

    }
}
