package com.rccloud.cloud.manager;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.api.utils.APIUtils;
import com.rccloud.cloud.command.commands.service.ServiceCreateCommand;
import com.rccloud.cloud.utils.MessageType;
import com.rccloud.cloud.utils.Color;

import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.Scanner;

public class SetupManager {

    public void downloadLanguages() {
        try {
            APIUtils.deleteFile("/home/cloud/lang/", "lang.properties");
            InputStream in = new URL("https://github.com/RC-Cloud/Languages/releases/download/latest/lang.zip").openStream();
            Files.copy(in, Paths.get("/home/cloud/lang/lang.zip"), StandardCopyOption.REPLACE_EXISTING);
            APIUtils.unzipFile("/home/cloud/lang", "lang.zip", "/home/cloud/lang");
            APIUtils.deleteFile("/home/cloud/lang/", "lang.zip");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void prefix() {
        RCCloud.getConsoleManager().sendMessage(Color.CYAN + "Setup " + Color.WHITE + "» " + Color.RESET, MessageType.SAMELINE);
    }

    public void startSetup() {
        RCCloud.getConsoleManager().sendMessage("Downloading Languages...", MessageType.DEBUG);
        downloadLanguages();

        while (true) {
            Scanner scanner = new Scanner(System.in);

            RCCloud.getConsoleManager().sendMessage("What language would you like to use?", MessageType.NOTHING);
            APIUtils.listFiles("/home/cloud/lang/", true);
            prefix();
            String lang = scanner.nextLine();

            File langFile = new File("/home/cloud/lang/", lang + ".properties");
            if (langFile.exists()) {
                RCCloud.getConsoleManager().sendMessage("Language file found, loading...", MessageType.INFO);

            } else {
                RCCloud.getConsoleManager().sendMessage("Language file not found, please try again.", MessageType.ERROR);
                startSetup();
            }


            RCCloud.getConsoleManager().sendMessage("Setting language to " + lang, MessageType.INFO);
            APIUtils.renameFile("/home/cloud/lang/" + lang + ".properties", "/home/cloud/lang/lang.properties");

            File finishedFile = new File("/home/cloud/setup/", "FINISHED");

                try {
                    finishedFile.getParentFile().mkdirs();
                    finishedFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            RCCloud.getConsoleManager().sendMessage("Setup Finished.", MessageType.INFO);
            return;

        }

    }

}
