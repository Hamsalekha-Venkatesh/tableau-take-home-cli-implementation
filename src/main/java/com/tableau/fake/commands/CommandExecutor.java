package com.tableau.fake.commands;

public final class CommandExecutor {
    /**
     * Called to execute this CLI. "args" should be equivalent to what's passed in on the command line.
     */
    public static String executeCommand(String... args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Command commandToRun = findCommand(args);
        String result = commandToRun.run(args);
        System.out.println(result);
        return result;
    }

    private static Command findCommand(String... args) {
        if (args[0] == null || args[0].isEmpty()) {
            throw new IllegalArgumentException("CLI must be run with args!");
        }
        String proposedCommand = args[0];
        for (Command command : CommandList.COMMANDS) {
            if (command.getName().equalsIgnoreCase(proposedCommand)) {
                return command;
            }
        }
        throw new IllegalArgumentException("CLI must be run with a valid command!");
    }
}