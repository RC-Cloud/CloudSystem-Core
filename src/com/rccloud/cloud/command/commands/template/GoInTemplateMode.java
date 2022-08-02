package com.rccloud.cloud.command.commands.template;

import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.command.Command;
import com.rccloud.cloud.command.commands.service.*;
import com.rccloud.cloud.utils.Color;
import com.rccloud.cloud.utils.MessageType;
import com.rccloud.cloud.utils.Utils;

import java.util.Scanner;

public class GoInTemplateMode extends Command {

    public GoInTemplateMode() {
        super("template");
    }

    @Override
    public void onCommand(String[] args) {
        while (true){
            Scanner scanner = new Scanner(System.in);
            RCCloud.getConsoleManager().sendMessage(Color.PURPLE + "Template " + Color.WHITE + "» " + Color.RESET, MessageType.SAMELINE);
            String command = scanner.nextLine();
            String[] commandArgs = command.split(" ");

            if(command.equalsIgnoreCase("exit") || command.equalsIgnoreCase("template")
                    || command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("leave")){
                break;

            }
            if(command.equalsIgnoreCase("help")) {
                Utils.sendTemplateHelpMessage();

            }
            if(command.equalsIgnoreCase("create")){
                TemplateCreateCommand.onTemplate(commandArgs);

            }
            if(command.equalsIgnoreCase("delete")){
                TemplateDeleteCommand.onTemplate(commandArgs);

            }
            if(command.equalsIgnoreCase("info")){
                TemplateInfoCommand.onTemplate(commandArgs);

            }
            if(command.equalsIgnoreCase("list")){
                TemplateListCommand.onTemplate(commandArgs);

            }
            if(command.equalsIgnoreCase("use")){
                TemplateUseCommand.onTemplate(commandArgs);

            }
        }
    }
}
