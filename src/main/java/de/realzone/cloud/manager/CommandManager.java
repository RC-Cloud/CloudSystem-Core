package de.realzone.cloud.manager;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.command.Command;
import de.realzone.cloud.command.commands.ShutdownCommand;
import de.realzone.cloud.command.commands.plugin.DownloadPlugin;
import de.realzone.cloud.command.commands.plugin.PluginHelpCommand;
import de.realzone.cloud.command.commands.service.*;
import de.realzone.cloud.utils.Color;
import de.realzone.cloud.utils.MessageType;
import de.realzone.cloud.utils.Utils;

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

        addCommand(new PluginHelpCommand());
        addCommand(new ShutdownCommand());
        addCommand(new DownloadPlugin());
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


            System.out.println(command + Arrays.toString(args));
            executeCommand(command, args);

        }
    }
}
