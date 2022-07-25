package com.rccloud.cloud.api;

import com.google.gson.Gson;
import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.api.utils.DownloadSoftware;
import com.rccloud.cloud.utils.MessageType;
import com.rccloud.cloud.api.enums.ServerType;
import com.rccloud.cloud.api.utils.APIUtils;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;


public class CloudAPI {

    public static void createServer(String version, ServerType serverType, int ram, int port) {

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

        if (APIUtils.findServer(serverName)) {
            APIUtils.deleteServer(new File("/home/servers/" + serverName));
        }
    }

    public static void getInformation(String serverName) {

        if (APIUtils.findServer(serverName)) {

            try {
                Gson gson = new Gson();

                Reader reader = Files.newBufferedReader(Paths.get("/home/servers/" + serverName + "/cloud.json"));

                Map<?, ?> map = gson.fromJson(reader, Map.class);

                //    JSONObject json = (JSONObject)new JSONParser().parse(IOUtils.toString(new URL("https://mcapi.us/server/status?ip=" + map.get("ip") + "&port=" + map.get("port")), StandardCharsets.UTF_8));

                RCCloud.getConsoleManager().sendMessage(" ", MessageType.NOTHING);
                RCCloud.getConsoleManager().sendMessage("Name: " + map.get("name"), MessageType.NOTHING);
                RCCloud.getConsoleManager().sendMessage("Version: " + map.get("version"), MessageType.NOTHING);
                RCCloud.getConsoleManager().sendMessage("Port: " + map.get("port").toString().split("\\.")[0], MessageType.NOTHING);
                RCCloud.getConsoleManager().sendMessage("Server Software: " + map.get("type"), MessageType.NOTHING);
                //      RCCloud.getConsoleManager().sendMessage("Status: " + ((Boolean) json.get("online") ? Color.GREEN + "Online" + Color.RESET : Color.RED + "Offline" + Color.RESET), MessageType.NOTHING);
                RCCloud.getConsoleManager().sendMessage(" ", MessageType.NOTHING);

                reader.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            RCCloud.getCloudManager().getLangProperties().getProperty("server_not_found");
        }
    }

    public static void changeVersion(ServerType serverType, String version) {

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

    public static void changeServerSoftware(String serverName, ServerType serverType, String version) {
        switch (serverType) {
            case BUNGEECORD:
                DownloadSoftware.downloadSoftwareBungeeCord();
                APIUtils.moveToServerDirectory(serverName, "bungeecord.jar");
                break;

            case PAPER:
                DownloadSoftware.downloadSoftwarePaper(version);
                APIUtils.moveToServerDirectory(serverName, "paper.jar");
                break;

            case SPIGOT:
                DownloadSoftware.downloadSoftwareSpigot(version);
                APIUtils.moveToServerDirectory(serverName, "spigot.jar");
                break;
        }
    }

    public static void changeName(String serverName, String newName) {
        APIUtils.renameFile(serverName, newName);
    }

    public static void changeRam(String serverName, ServerType serverType, int ram) {
        APIUtils.createStartFile(serverName, serverType, ram);
    }

    public static void changePort(String serverName, int port) {
        APIUtils.createServerProperties(serverName, port);
    }

    public static void startServer(String serverName) {
        ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command("/home/servers/" + serverName + "/start.sh");

    }

    public static void stopServer(String serverName) {
        //screen -S sessionname -X stuff 'command'`echo -ne '\015'`
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("screen -S " + serverName + " -X stuff 'stop'`echo -ne '\015'`");
    }

    public static boolean isServerOnline(String serverName) {

        if (APIUtils.findServer(serverName)) {

            try {
                Gson gson = new Gson();

                Reader reader = Files.newBufferedReader(Paths.get("/home/servers/" + serverName + "/cloud.json"));

                Map<?, ?> map = gson.fromJson(reader, Map.class);

                JSONObject json = (JSONObject) new JSONParser().parse(IOUtils.toString(new URL("https://mcapi.us/server/status?ip=" + map.get("ip") + "&port=" + map.get("port")), StandardCharsets.UTF_8));

                if ((Boolean) json.get("online")) {
                    reader.close();
                    return true;
                } else {
                    reader.close();
                    return false;
                }


            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else {
            RCCloud.getCloudManager().getLangProperties().getProperty("server_not_found");
        }
        return false;
    }

    public static void connectToServer(String serverName) {

    }

    public static void sendCommand(String serverName, String command) {

        //screen -S sessionname -X stuff 'command'`echo -ne '\015'`
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("screen -S " + serverName + " -X stuff '" + command + "'`echo -ne '\015'`");
    }
}
