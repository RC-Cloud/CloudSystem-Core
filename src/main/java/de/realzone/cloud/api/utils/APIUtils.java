package de.realzone.cloud.api.utils;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.api.enums.Plugins;
import de.realzone.cloud.api.enums.ServerType;
import de.realzone.cloud.utils.MessageType;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class APIUtils {

    public static void moveToServerDirectory(String serverName, String fileName) {
        try {
            createServerDirectory(serverName);
            Files.move(Paths.get(fileName), Paths.get("/home/servers/" + serverName + "/" + fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void moveToDirecotry(String serverName, String path, String fileName) {
        try {
            createServerDirectory(serverName);
            Files.move(Paths.get(fileName), Paths.get("/home/servers/" + serverName + "/" + path + "/" + fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void movePlugin(String oldService, String newService, String plugin){

        try {
            Files.move(Paths.get("/home/servers/" + oldService + "/plugins/" + plugin), Paths.get("/home/servers/" + newService + "/plugins/" + plugin), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String path, String file){
        File file1 = new File(path + "/" + file);
        if(file1.delete()){
            //Deleted file successfully
        }else {
            RCCloud.getConsoleManager().sendMessage("Could not delete file", MessageType.ERROR);
            return;
        }
    }

    public static void renameFile(String fileName, String newFileName) {

        try {
            Files.move(Paths.get(fileName), Paths.get(newFileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public static void createBungeeConfig(String serverName, int port, String minecraftUser){
        FileWriter config = null;
        try {
            config = new FileWriter("config.yml");

            config.write("server_connect_timeout: 5000\n" +
                    "remote_ping_cache: -1\n" +
                    "forge_support: false\n" +
                    "player_limit: -1\n" +
                    "permissions:\n" +
                    "  default:\n" +
                    "  - bungeecord.command.server\n" +
                    "  - bungeecord.command.list\n" +
                    "  admin:\n" +
                    "  - bungeecord.command.alert\n" +
                    "  - bungeecord.command.end\n" +
                    "  - bungeecord.command.ip\n" +
                    "  - bungeecord.command.reload\n" +
                    "timeout: 30000\n" +
                    "log_commands: false\n" +
                    "network_compression_threshold: 256\n" +
                    "online_mode: true\n" +
                    "disabled_commands:\n" +
                    "- disabledcommandhere\n" +
                    "servers:\n" +
                    "  lobby:\n" +
                    "    motd: '&1Just another BungeeCord - Forced Host'\n" +
                    "    address: localhost:25565\n" +
                    "    restricted: false\n" +
                    "listeners:\n" +
                    "- query_port: " + port + "\n" +
                    "  motd: '&1Another Bungee server'\n" +
                    "  tab_list: GLOBAL_PING\n" +
                    "  query_enabled: false\n" +
                    "  proxy_protocol: false\n" +
                    "  forced_hosts:\n" +
                    "    pvp.md-5.net: pvp\n" +
                    "  ping_passthrough: false\n" +
                    "  priorities:\n" +
                    "  - lobby\n" +
                    "  bind_local_address: true\n" +
                    "  host: 0.0.0.0:" + port + "\n" +
                    "  max_players: 1\n" +
                    "  tab_size: 60\n" +
                    "  force_default_server: false\n" +
                    "ip_forward: false\n" +
                    "remote_ping_timeout: 5000\n" +
                    "prevent_proxy_connections: false\n" +
                    "groups:\n" +
                    "  " + minecraftUser + ":\n" +
                    "  - admin\n" +
                    "connection_throttle: 4000\n" +
                    "stats: a95423b9-1ec5-41a4-a085-7c3e22c280d1\n" +
                    "connection_throttle_limit: 3\n" +
                    "log_pings: true\n");
            config.close();
            moveToServerDirectory(serverName, "config.yml");

        } catch (IOException e) {
            e.printStackTrace();
        }
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
                eula.write("screen -xmS " + serverName + " java -Xms" + ram + "M -Xmx" + ram + "M -jar paper.jar -nogui \n" +
                        "pause");
            } else if (serverType == ServerType.SPIGOT) {
                eula.write("screen -xmS " + serverName + " java -Xms" + ram + "M -Xmx" + ram + "M -jar spigot.jar \n" +
                        "pause");
            } else if (serverType == ServerType.BUNGEECORD) {
                eula.write("screen -xmS " + serverName + " java -Xms" + ram + "M -Xmx" + ram + "M -jar bungeecord.jar \n" +
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

    public static boolean findServer(String serverName){
        Path serverPath = Paths.get("/home/servers/" + serverName);
        if(Files.exists(serverPath)){
            return true;
        } else {
            return false;
        }
    }

    public static void listPlugins(String serverName){
        File file = new File("/home/servers/" + serverName + "/plugins");
        if(file.exists()){
            int i = 0;

            File[] files = file.listFiles();
            for(File f : files){
                i++;
                System.out.println(i + ". " + f.getName());
            }
            i = 0;
        }

    }

    public static void listServers(){
        File file = new File("/home/servers/");
        String[] directories = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });

        int i = 0;
        for(String key : Arrays.asList(directories)){
            if(!key.contains(".")){
                i++;
                System.out.println(i + ". " + key + "");
            }
        }
        i = 0;
    }

    public static boolean deleteServer(File directory) {
        if(directory.exists()){
            File[] files = directory.listFiles();
            if(null!=files){
                for(int i=0; i<files.length; i++) {
                    if(files[i].isDirectory()) {
                        deleteServer(files[i]);
                    }
                    else {
                        files[i].delete();
                    }
                }
            }
        }
        return(directory.delete());
    }

    public static void installPlugins(String serverName, Plugins pluginName) {

        File directory = new File("/home/servers/" + serverName + "/plugins/");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        if(pluginName == Plugins.ESSENTIALSX){
            DownloadSoftware.downloadPlugin("EssentialsX", "https://github.com/EssentialsX/Essentials/releases/download/2.19.4/EssentialsX-2.19.4.jar");
            moveToDirecotry(serverName, "plugins", "EssentialsX.jar");

        }else if(pluginName == Plugins.LUCKPERMS){
            DownloadSoftware.downloadPlugin("LuckPerms", "https://download.luckperms.net/1441/bukkit/loader/LuckPerms-Bukkit-5.4.33.jar");
            moveToDirecotry(serverName, "plugins", "LuckPerms.jar");

        }else if(pluginName == Plugins.MAINTENANCE){
            DownloadSoftware.downloadPlugin("Maintenance", "https://github.com/kennytv/Maintenance/releases/download/4.0.1/Maintenance.jar");
            moveToDirecotry(serverName, "plugins", "Maintenance.jar");

        }else if(pluginName == Plugins.PEX){
            DownloadSoftware.downloadPlugin("PermissionsEX", "https://github.com/PEXPlugins/PermissionsEx/releases/download/STABLE-1.23.4/PermissionsEx-1.23.4.jar");
            moveToDirecotry(serverName, "plugins", "PermissionsEX.jar");

        }else if(pluginName == Plugins.PROTOCOLLIB){
            DownloadSoftware.downloadPlugin("ProtocolLib ", "https://github.com/dmulloy2/ProtocolLib/releases/download/4.8.0/ProtocolLib.jar");
            moveToDirecotry(serverName, "plugins", "ProtocolLib.jar");

        }else if(pluginName == Plugins.TAB){
            DownloadSoftware.downloadPlugin("Tab", "https://github.com/NEZNAMY/TAB/releases/download/3.1.2/TAB.v3.1.2.jar");
            moveToDirecotry(serverName, "plugins", "Tab.jar");

        }else if(pluginName == Plugins.VAULT){
            DownloadSoftware.downloadPlugin("Vault", "https://github.com/MilkBowl/Vault/releases/download/1.7.3/Vault.jar");
            moveToDirecotry(serverName, "plugins", "Vault.jar");

        }else if(pluginName == Plugins.VIABACKWARDS){
            DownloadSoftware.downloadPlugin("ViaBackwards", "https://github.com/ViaVersion/ViaBackwards/releases/download/4.3.1/ViaBackwards-4.3.1.jar");
            moveToDirecotry(serverName, "plugins", "ViaBackwards.jar");

        }else if(pluginName == Plugins.VIAVERSION){
            DownloadSoftware.downloadPlugin("ViaVersion", "https://github.com/ViaVersion/ViaVersion/releases/download/4.3.1/ViaVersion-4.3.1.jar");
            moveToDirecotry(serverName, "plugins", "ViaVersion.jar");

        }else if(pluginName == Plugins.WORLDEDIT){
            DownloadSoftware.downloadPlugin("Worldedit", "https://dev.bukkit.org/projects/worldedit/files/latest");
            moveToDirecotry(serverName, "plugins", "Worldedit.jar");

        }else if(pluginName == Plugins.WORLDGUARD){
            DownloadSoftware.downloadPlugin("WorldGuard", "https://dev.bukkit.org/projects/worldguard/files/latest");
            moveToDirecotry(serverName, "plugins", "WorldGuard.jar");

        }

    }
}
