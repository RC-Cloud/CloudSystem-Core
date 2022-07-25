package com.rccloud.cloud.manager;

import com.rccloud.cloud.utils.MessageType;
import com.rccloud.cloud.utils.Color;

public class ConsoleManager {

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
            case PREFIX -> System.out.println(prefix + message + Color.RESET);
            case SAMELINE -> System.out.print(message + Color.RESET);
        }
    }
}
