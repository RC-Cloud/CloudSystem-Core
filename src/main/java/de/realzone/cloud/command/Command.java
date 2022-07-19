package de.realzone.cloud.command;

import lombok.Getter;

@Getter
public abstract class Command {

    private String command;

    public Command(String command){
        this.command = command;
    }

    public abstract void onCommand(String[] args);

}
