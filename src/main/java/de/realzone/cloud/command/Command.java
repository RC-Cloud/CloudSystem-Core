package de.realzone.cloud.command;

import lombok.Getter;

@Getter
public abstract class Command {

    private String command;
    private String[] alias;

    public Command(String command, String... alias){
        this.command = command;
        this.alias = alias;
    }

    public Command(String command){
        this.command = command;
        this.alias = null;
    }

    public abstract void execute(String[] args);

}
