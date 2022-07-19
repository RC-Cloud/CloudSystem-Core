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
            info.put("ip", port);


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

    public static void createServerProperties(String serverName) {

    }

    public static void createBungeeCordConfig(String serverName) {

    }

    public static void createStartFile(String serverName, ServerType serverType, int ram) {
        try {
            FileWriter eula = new FileWriter("start.sh");
            if (serverType == ServerType.PAPER) {
                eula.write("java Xms" + ram + "M -Xmx" + ram + "M -jar paper.jar -nogui \n" +
                        "pause");
            } else if (serverType == ServerType.SPIGOT) {
                eula.write("java Xms" + ram + "M -Xmx" + ram + "M -jar spigot.jar \n" +
                        "pause");
            } else if (serverType == ServerType.BUNGEECORD) {
                eula.write("java Xms" + ram + "M -Xmx" + ram + "M -jar bungeecord.jar \n" +
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
