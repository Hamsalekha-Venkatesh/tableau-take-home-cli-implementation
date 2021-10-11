package com.tableau.fake.commands;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelpTest {
    public Help subject;

    @Before
    public void setUp() {
        subject = new Help();
    }

    /**
     *  Description: tests for case ["help"]
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    @Test
    public void testHelp_WithZeroParams() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        String expectedValue = "NAME: Help \n" +
                "DESCRIPTION: Returns help for commands in this CLI";

        String actualValue = subject.run("Help");
        System.out.println(actualValue);
        assertEquals("Help Description Mismatch for 'Help' command", expectedValue.trim(), actualValue.trim());
    }

    /**
     *  Description: tests for case ["help", "Change", "filename"]
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    @Test
    public void testHelp_GivenValidCommand_WithOptionsParam() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        String expectedValue = "NAME: com.tableau.fake.commands.Change \n" +
                "DESCRIPTION: This command allows a user to change a setting on the server.\n" +
                "USAGE(S): --new-value <newValue> --setting-name <nameOfSetting>\n" +
                "OPTIONS(S): [--server, --timeout, --setting-name, --new-value]";

        String actualValue = subject.run("Help", "change"," fileName");
        System.out.println(actualValue);
        assertEquals("Help Description Mismatch for'change' command", expectedValue.trim(), actualValue.trim());
    }

    /**
     *  Description: tests for case ["help", "backup"]
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    @Test
    public void testHelp_GivenValidCommand_WithNoUsageParam() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        String expectedValue = "NAME: com.tableau.fake.commands.Backup \n" +
                "DESCRIPTION: IN DEVELOPMENT!!! This command allows a user to backup data from the server.\n" +
                "OPTIONS(S): [--server, --timeout, --backup-file-name]";

        String actualValue = subject.run("Help", "backup");
        System.out.println(actualValue);
        assertEquals("Help Description Mismatch for 'backup' Command", expectedValue.trim(), actualValue.trim());
    }

    /**
     *  Description: tests for case ["help", "wrongCommand"]
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     * @throws InstantiationException
     */
    @Test(expected = ClassNotFoundException.class)
    public void testHelp_InvalidCommand_throwsClassNotFoundException() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        subject.run("help", "wrongCommand", "someArgs");
    }
}
