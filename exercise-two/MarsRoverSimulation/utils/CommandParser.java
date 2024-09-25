package utils;

import commands.*;

import java.util.List;
import java.util.ArrayList;

public class CommandParser {
    public static List<Command> parseCommands(String commandString) {
        List<Command> commands = new ArrayList<>();
        for (char c : commandString.toCharArray()) {
            switch (c) {
                case 'M':
                    commands.add(new MoveCommand());
                    break;
                case 'L':
                    commands.add(new TurnLeftCommand());
                    break;
                case 'R':
                    commands.add(new TurnRightCommand());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command: " + c);
            }
        }
        return commands;
    }
}