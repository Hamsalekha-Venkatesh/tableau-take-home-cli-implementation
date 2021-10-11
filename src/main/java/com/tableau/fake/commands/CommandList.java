package com.tableau.fake.commands;

import java.util.Arrays;
import java.util.List;

public final class CommandList {
    public static final List<Command> COMMANDS = Arrays.asList(
            new Backup(),
            new Change(),
            new Get(),
            new Help(),
            new Start()
    );
}