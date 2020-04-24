package ru.naumkin.tm;

import ru.naumkin.tm.enumerated.TerminalCommand;
import ru.naumkin.tm.context.CommandHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {
        System.out.println( "*** Welcome to task manager ***" );

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            CommandHandler commandHandler = new CommandHandler(reader);

            while (true) {
                TerminalCommand command = commandHandler.readCommand(reader);
                boolean commandIsExit = command.getCommand().equals(TerminalCommand.EXIT.getCommand());
                if (commandIsExit) {
                    System.exit(1);
                } else {
                    commandHandler.handleCommand(command);
                }
            }

        }
    }

}
