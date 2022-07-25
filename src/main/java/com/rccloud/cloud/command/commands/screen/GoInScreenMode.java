package com.rccloud.cloud.command.commands.screen;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.command.Command;
import com.rccloud.cloud.utils.Color;
import com.rccloud.cloud.utils.MessageType;
import com.rccloud.cloud.utils.Utils;

import java.util.Scanner;

public class GoInScreenMode extends Command {

    public GoInScreenMode() {
        super("screen");
    }

    @Override
    public void onCommand(String[] args) {

        while (true){
            Scanner scanner = new Scanner(System.in);

            RCCloud.getConsoleManager().sendMessage(Color.BLUE + "Screen " + Color.WHITE + "» " + Color.RESET, MessageType.SAMELINE);
            String command = scanner.nextLine();
            String[] commandArgs = command.split(" ");

            if(command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("screen")
                || command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("leave")) {
                break;
            }else if(command.equalsIgnoreCase("help")) {
                Utils.sendScreenHelpMessage();

            }
        }

    }
}
