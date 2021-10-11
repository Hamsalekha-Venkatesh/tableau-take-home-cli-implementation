package com.tableau.fake.commands;

import java.util.Arrays;
/**
 * Instructions
    Spend 2-3 hours developing this solution.
    1) Read source code for available defined interfaces and general functionality. Also, reread question description.
    2) Implement functionality to the level of sending out a PR.
    
    What we're looking for:
    Code that is easy to understand for a developer who has never seen it before (clean code)
    Solution that is integrated well into the source code and utilizes existing functionality
    Solution adequately displays all available information about each command
    Tests that ensure the help command still works as expected as new commands are added
    Please add comments where helpful as we will not be having an in-person interview about this problem
    
    What we're not looking for:
    Extensions of the original problem (mention ideas in comments). Only implement the two functions asked for in the problem description.
    (Seeing all the commands and printing out all info about a specific command.)
    If you see any coding mistakes as you are reading through the rest of the code you can fix them or leave a comment explaining what you would do.
*/
public class Help extends Command {

    @Override
    public String run(String... args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        /**
         * Any command will be of the form ["help"] OR ["help", "arg1", "arg2"]
         * This function gets the command name from the arguments, makes the first letter caps lock to invoke the class name...
         * Then it tries to gets the corresponding instance to execute the method..
         */

        // Case 1: help with no params
        if(args.length == 1) {
            StringBuilder helpDescriptionBuilder = new StringBuilder();
            helpDescriptionBuilder.append("NAME: ").append("Help" + " \n");
            helpDescriptionBuilder.append("DESCRIPTION: ").append(this.getDescription()).append("\n");

            return helpDescriptionBuilder.toString();
        }

        // Case 2: help with 1 or more params.
        String command = args[1];
        command = command.substring(0, 1).toUpperCase() + command.substring(1);
        Class<?> classToBeCalled;

        Command commandThatNeedsHelp;
        try {
            classToBeCalled = Class.forName("com.tableau.fake.commands." + command);

            commandThatNeedsHelp = (Command) classToBeCalled.newInstance();

            StringBuilder detailedCommandDescription = new StringBuilder();
            detailedCommandDescription.append("NAME: ");
            detailedCommandDescription.append(commandThatNeedsHelp.getClass().getName() + " \n");
            detailedCommandDescription.append("DESCRIPTION: ");
            detailedCommandDescription.append(commandThatNeedsHelp.getDescription() + "\n");

            if(commandThatNeedsHelp.getUsage() != null) {
                detailedCommandDescription.append("USAGE(S): ");
                detailedCommandDescription.append(commandThatNeedsHelp.getUsage() + "\n");
            }

            if(commandThatNeedsHelp.getOptions()!= null) {
                detailedCommandDescription.append("OPTIONS(S): ");
                detailedCommandDescription.append(commandThatNeedsHelp.getOptions() + "\n");
            }
            return detailedCommandDescription.toString();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | IllegalArgumentException e) {
            throw e;
        }
    }

    @Override
    String getName() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    @Override
    String getDescription() {
        return "Returns help for commands in this CLI";
    }

    @Override
    String getUsage() {
        return null; // TODO Complete this usage as is relevant to your help design
    }
}
