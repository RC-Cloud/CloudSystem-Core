package com.rccloud.cloud.manager;

import com.rccloud.cloud.command.Command;
import com.rccloud.cloud.command.commands.HelpCommand;
import com.rccloud.cloud.command.commands.plugin.GoInPluginMode;
import com.rccloud.cloud.RCCloud;
import com.rccloud.cloud.command.commands.ShutdownCommand;
import com.rccloud.cloud.command.commands.screen.GoInScreenMode;
import com.rccloud.cloud.command.commands.service.GoInServiceMode;
import com.rccloud.cloud.command.commands.template.GoInTemplateMode;
import com.rccloud.cloud.utils.Color;
import com.rccloud.cloud.utils.MessageType;
import com.rccloud.cloud.utils.Utils;

import java.util.*;

public class CommandManager {

    private Set<Command> commands;
    private Scanner scanner = new Scanner(System.in);

    public CommandManager() {
        this.commands = new HashSet<Command>();
    }

    public void addCommand(Command cmd) {
        this.commands.add(cmd);
    }

    public void executeCommand(String command, String[] args) {
        Command cmd = getCommand(command);

        if (cmd != null) {
            cmd.onCommand(args);
        } else {
            RCCloud.getConsoleManager().sendMessage(RCCloud.getCloudManager().getLangProperties().getProperty("command_not_found"), MessageType.INFO);
        }
    }

    public Command getCommand(String name) {

        for (Command command : this.commands) {
            if (command.getCommand().equalsIgnoreCase(name)) {
                return command;
            }
        }
        return null;
    }

    public void loadCommands() {
        //Service Commands
        addCommand(new GoInServiceMode());

        //Plugin Commands
        addCommand(new GoInPluginMode());

        //Screen Commands
        addCommand(new GoInScreenMode());

        //Other
        addCommand(new ShutdownCommand());
        addCommand(new HelpCommand());
        addCommand(new GoInTemplateMode());
    }

    public Set<Command> getCommands() {
        return commands;
    }

    public void readCommand() {

        while (true) {
            System.out.print(Color.RED + "CloudSystem " + Color.WHITE + "» " + Color.RESET);
            String answer = scanner.nextLine();

            String command = answer.split(" ")[0];
            String[] args = Utils.dropFirstString(answer.split(" "));

            executeCommand(command, args);

        }
    }
}
