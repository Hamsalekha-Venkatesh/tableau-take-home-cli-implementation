package com.tableau.fake.commands;

import java.util.Arrays;
import java.util.List;

public class Backup extends Command {
    @Override
    public String run(String... args) {
        return "Backup with these args: " + Arrays.toString(args);
    }

    @Override
    String getName() {
        return "backup";
    }

    @Override
    String getDescription() {
        return "IN DEVELOPMENT!!! This command allows a user to backup data from the server.";
    }

    @Override
    String getUsage() {
        return null;
    }

    @Override
    List<String> getOptions() {
        List<String> options = super.getOptions();
        options.add("--backup-file-name");
        return options;
    }
    
    @Override
    boolean isHidden() {
        return true;
    }
}