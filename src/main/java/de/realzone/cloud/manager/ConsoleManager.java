package de.realzone.cloud.manager;

import de.realzone.cloud.RCCloud;
import de.realzone.cloud.utils.Color;
import de.realzone.cloud.utils.MessageType;
import lombok.Getter;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.ReaderUtils;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ConsoleManager {

    public LineReader createLineReader(){
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

    public void sendMessage(String message, MessageType type){
        final String prefix = Color.BLUE + "CloudSystem " + Color.WHITE + "» " + Color.RESET;
        final String info = Color.BLUE + "INFO" + Color.RESET + ": ";
        final String warn = Color.YELLOW_BRIGHT + "WARN" + Color.RESET + ": ";
        final String error = Color.RED_BRIGHT + "ERROR" + Color.RESET + ": ";
        final String debug = Color.GREEN + "DEBUG" + Color.RESET + ": ";

        switch (type){
            case INFO -> System.out.println(info + message + Color.RESET);
            case WARN -> System.out.println(warn + message + Color.RESET);
            case ERROR -> System.out.println(error + message + Color.RESET);
            case DEBUG -> System.out.println(debug + message + Color.RESET);
            case NOTHING -> System.out.println(message + Color.RESET);
        }
    }
}
