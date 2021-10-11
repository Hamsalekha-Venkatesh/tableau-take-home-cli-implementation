package com.tableau.fake.commands;

import java.util.ArrayList;
import java.util.List;

public abstract class Command {

    /**
     * Returns a string that represents the output of running this command.
     */
    public abstract String run(String... args) throws InstantiationException, IllegalAccessException, ClassNotFoundException;

    /**
     * Returns the name of the command.
     */
    abstract String getName();

    /**
     * Returns string describing what the command does.
     */
    abstract String getDescription();

    /**
     * Returns a usage string to demonstrate how the command should be used. Usage string begins after the command name.
     */
    abstract String getUsage();

    /**
     * Returns whether a command is hidden from the user or not. Returns false by default.
     */
    boolean isHidden() {
        return false;
    }

    /**
     * Returns a list of the options available to this command.
     */
    List<String> getOptions() {
        // All commands should be able to specify a custom server address and timeout.
        List<String> globalOptions = new ArrayList<>();
        globalOptions.add("--server");
        globalOptions.add("--timeout");
        return globalOptions;
    }
}
