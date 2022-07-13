package de.realzone.cloud.api;


import de.realzone.cloud.RCCloud;
import de.realzone.cloud.utils.Color;
import de.realzone.cloud.utils.MessageType;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TerminalReader {

    public static LineReader reader = createLineReader();

    public static LineReader createLineReader() {
        try {
            Terminal terminal = TerminalBuilder.builder().system(true).streams(System.in, System.out).encoding(StandardCharsets.UTF_8).dumb(true).build();

            return LineReaderBuilder.builder().terminal(terminal)
                    .option(LineReader.Option.DISABLE_EVENT_EXPANSION, true)
                    .option(LineReader.Option.AUTO_REMOVE_SLASH, true)
                    .option(LineReader.Option.INSERT_TAB, false).build();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void createLine(String prefix) {

        while (true) {
            String s = reader.readLine(prefix + Color.RESET);
            String[] input = s.split(" ");

            List<String> args = new ArrayList<>();
            for (String i : input) {
                if (!i.equalsIgnoreCase(input[0])) {
                    args.add(i);
                }
            }
        }
    }

    public static boolean createAndReadLine(String prefix, String read, int args) {

        while (true) {
            String s = reader.readLine(prefix + Color.RESET);
            String[] input = s.split(" ");

            if(read.equalsIgnoreCase(input[args])){
                return true;
            }else{
                return false;
            }
        }
    }

    public static void createServer(String servername, String version, ServerType servertype, int ram, int port) {

    }

    public static void deleteServer(String servername) {

    }

    public static void startServer(String servername) {

    }

    public static void stopServer(String servername) {

    }

    public static void connectToServer(String servername, int port /* TODO remove Port */) {

    }

    public static void sendCommand(String servername, int port /* TODO remove Port */) {

    }
}
