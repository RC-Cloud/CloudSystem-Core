package com.rccloud.cloud.manager;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.api.utils.APIUtils;
import com.rccloud.cloud.command.commands.service.ServiceCreateCommand;
import com.rccloud.cloud.utils.MessageType;
import com.rccloud.cloud.utils.Color;
import com.rccloud.cloud.utils.Utils;

import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.Scanner;

public class SetupManager {

    public void downloadLanguages() {
        try {
            File langFile = new File("/home/cloud/setup/", "languages.txt");
            if(langFile.exists()){
                langFile.delete();
            }
            File langFolder = new File("/home/cloud/lang/");
            if(!langFolder.exists()){
                langFolder.mkdirs();
            }
            InputStream in = new URL("https://github.com/RC-Cloud/Languages/releases/download/latest/lang.zip").openStream();
            Files.copy(in, Paths.get("/home/cloud/lang/lang.zip"), StandardCopyOption.REPLACE_EXISTING);
            APIUtils.unzipFile("/home/cloud/lang/", "lang.zip", "/home/cloud/lang");
            APIUtils.deleteFile("/home/cloud/lang/", "lang.zip");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void prefix() {
        RCCloud.getConsoleManager().sendMessage(Color.CYAN + "Setup " + Color.WHITE + "» " + Color.RESET, MessageType.SAMELINE);
    }

    public void startSetup() { //TODO Add Template Command and put in here

        File setupFile = new File("/home/cloud/setup/", "INSTALLED");
        File finishedFile = new File("/home/cloud/setup/", "FINISHED");
        if(setupFile.exists() && finishedFile.exists()){
            return;
        }else {
            Utils.sendEmptyMessages();

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

                try {
                    finishedFile.getParentFile().mkdirs();
                    finishedFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                RCCloud.getConsoleManager().sendMessage("Setup Finished. Do you want to create a Server? (y/n)", MessageType.SAMELINE);
                String createServer = scanner.nextLine();
                if(createServer.equalsIgnoreCase("y")){
                    ServiceCreateCommand.onService(null);

                }else if(createServer.equalsIgnoreCase("n")) {
                    RCCloud.getConsoleManager().sendMessage("Setup Finished.", MessageType.INFO);
                    return;
                }else{
                    RCCloud.getConsoleManager().sendMessage("Invalid input, please try again.", MessageType.ERROR);
                    startSetup();
                }
                return;

            }
        }
    }

}
