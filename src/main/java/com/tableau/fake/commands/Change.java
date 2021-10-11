package com.tableau.fake.commands;

import java.util.Arrays;
import java.util.List;

public class Change extends Command {
    @Override
    public String run(String... args) {
        return "Change with these args: " + Arrays.toString(args);
    }

    @Override
    String getName() {
        return "";
    }

    @Override
    String getDescription() {
        return "This command allows a user to change a setting on the server.";
    }

    @Override
    String getUsage() {
        return "--new-value <newValue> --setting-name <nameOfSetting>";
    }

    @Override
    List<String> getOptions() {
        List<String> options = super.getOptions();
        options.add("--setting-name");
        options.add("--new-value");
        return options;
    }
}