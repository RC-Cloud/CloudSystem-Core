package de.realzone.cloud.api.utils;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.api.enums.Plugins;
import de.realzone.cloud.api.enums.ServerType;
import de.realzone.cloud.utils.Color;
import de.realzone.cloud.utils.MessageType;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class APIUtils {

    public static void moveToServerDirectory(String serverName, String fileName) {
        try {
            createServerDirectory(serverName);
            Files.move(Paths.get(fileName), Paths.get("/home/servers/" + serverName + "/" + fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void renameFile(String serverName, String fileName, String newFileName) {

    }

    public static void createEula(String serverName) {
        try {
            FileWriter eula = new FileWriter("eula.txt");
            eula.write("#By changing the setting below to TRUE you are indicating your agreement to our EULA (https://aka.ms/MinecraftEULA).\n" +
                    "eula=true\n" +
                    "\n");
            eula.close();
            moveToServerDirectory(serverName, "eula.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createJsonFile(String serverName, String version, ServerType serverType, int ram, int port) {
        try {

            JSONObject info = new JSONObject();
            info.put("name", serverName);
            info.put("version", version);
            info.put("port", port);
            info.put("ram", ram);


            if(serverType == ServerType.BUNGEECORD){
                info.put("type", "BungeeCord");

            } else if(serverType == ServerType.SPIGOT){
                info.put("type", "Spigot");

            } else if (serverType == ServerType.PAPER){
                info.put("type", "Paper");

            }else{
                info.put("type", "Unknown");
            }


            FileWriter cloud = null;
            cloud = new FileWriter("cloud.json");

            cloud.write(info.toJSONString());
            cloud.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        moveToServerDirectory(serverName, "cloud.json");
    }

    public static void createServerProperties(String serverName, int port) {
        FileWriter serverprop = null;
        try {
            serverprop = new FileWriter("server.properties");

        serverprop.write("#Minecraft server properties\n" +
                "enable-jmx-monitoring=false\n" +
                "rcon.port=" + port + "\n" +
                "level-seed=\n" +
                "gamemode=survival\n" +
                "enable-command-block=false\n" +
                "enable-query=false\n" +
                "generator-settings=\n" +
                "level-name=world\n" +
                "motd=A Minecraft Server\n" +
                "query.port=" + port + "\n" +
                "pvp=true\n" +
                "generate-structures=true\n" +
                "difficulty=easy\n" +
                "network-compression-threshold=256\n" +
                "max-tick-time=60000\n" +
                "use-native-transport=true\n" +
                "max-players=20\n" +
                "online-mode=true\n" +
                "enable-status=true\n" +
                "allow-flight=false\n" +
                "broadcast-rcon-to-ops=true\n" +
                "view-distance=10\n" +
                "max-build-height=256\n" +
                "server-ip=\n" +
                "allow-nether=true\n" +
                "server-port=" + port + "\n" +
                "enable-rcon=false\n" +
                "sync-chunk-writes=true\n" +
                "op-permission-level=4\n" +
                "prevent-proxy-connections=false\n" +
                "resource-pack=\n" +
                "entity-broadcast-range-percentage=100\n" +
                "rcon.password=\n" +
                "player-idle-timeout=0\n" +
                "debug=false\n" +
                "force-gamemode=false\n" +
                "rate-limit=0\n" +
                "hardcore=false\n" +
                "white-list=false\n" +
                "broadcast-console-to-ops=true\n" +
                "spawn-npcs=true\n" +
                "spawn-animals=true\n" +
                "snooper-enabled=true\n" +
                "function-permission-level=2\n" +
                "level-type=default\n" +
                "text-filtering-config=\n" +
                "spawn-monsters=true\n" +
                "enforce-whitelist=false\n" +
                "resource-pack-sha1=\n" +
                "spawn-protection=16\n" +
                "max-world-size=29999984\n");
        serverprop.close();
        moveToServerDirectory(serverName, "server.properties");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createStartFile(String serverName, ServerType serverType, int ram) {
        try {
            FileWriter eula = new FileWriter("start.sh");
            if (serverType == ServerType.PAPER) {
                eula.write("java -Xms" + ram + "M -Xmx" + ram + "M -jar paper.jar -nogui \n" +
                        "pause");
            } else if (serverType == ServerType.SPIGOT) {
                eula.write("java -Xms" + ram + "M -Xmx" + ram + "M -jar spigot.jar \n" +
                        "pause");
            } else if (serverType == ServerType.BUNGEECORD) {
                eula.write("java -Xms" + ram + "M -Xmx" + ram + "M -jar bungeecord.jar \n" +
                        "pause");
            }
            eula.close();
            moveToServerDirectory(serverName, "start.sh");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createServerDirectory(String serverName) {
        File directory = new File("/home/servers/" + serverName);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public static void installPlugins(String serverName, Plugins pluginName) {

    }
}
