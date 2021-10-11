package com.tableau.fake.commands;

import java.util.Arrays;
import java.util.List;

public class Get extends Command {
    @Override
    public String run(String... args) {
        return "Running get with args " + Arrays.toString(args);
    }

    @Override
    String getName() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    @Override
    String getDescription() {
        return "Gets the value of a setting from the server.";
    }

    @Override
    String getUsage() {
        return "--setting-name <nameOfSetting> [--return-default]";
    }

    @Override List<String> getOptions() {
        List<String> options = Arrays.asList(
                "--setting-name",
                "--return-default");
        return options;
    }
}