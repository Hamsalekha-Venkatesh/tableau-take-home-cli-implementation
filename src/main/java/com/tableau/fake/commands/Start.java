package com.tableau.fake.commands;

import java.util.Arrays;

public class Start extends Command {
    @Override
    public String run(String... args) {
        return "Running start with args " + Arrays.toString(args);
    }

    @Override
    String getName() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    @Override
    String getDescription() {
        return "The Start command starts the server.";
    }

    @Override
    String getUsage() {
        return "";
    }
}
