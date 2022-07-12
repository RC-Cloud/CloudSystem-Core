package de.realzone.cloud.manager;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.command.Command;
import de.realzone.cloud.utils.Color;
import de.realzone.cloud.utils.MessageType;
import lombok.Getter;
import org.jline.reader.LineReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommandManager {

    @Getter
    private final HashMap<String, Command> commands = new HashMap<>();

    public void registerCommand(Command command) {
        commands.put(command.getCommand().toLowerCase(), command);

        if (command.getAlias() == null) return;

        for (String alias : command.getAlias()) {
            commands.put(alias.toLowerCase(), command);
        }
    }

    public Runnable reading() {
        return new Runnable() {
            @Override
            public void run() {
                LineReader reader = RCCloud.getConsoleManager().createLineReader();

                while (true) {
                    String s = reader.readLine(Color.RED + "CloudSystem " + Color.WHITE + "» " + Color.RESET);
                    String[] input = s.split(" ");

                    if (commands.containsKey(input[0].toLowerCase())) {
                        List<String> args = new ArrayList<>();
                        for (String i : input) {
                            if (!i.equalsIgnoreCase(input[0])) {
                                args.add(i);
                            }
                        }
                        commands.get(input[0].toLowerCase()).execute(args.toArray(new String[0]));
                    } else {
                        RCCloud.getConsoleManager().sendMessage("The Command '" + input[0] + "' could not be found! Type 'help' for help.", MessageType.INFO);
                    }

                }
            }
        };
    }

}
