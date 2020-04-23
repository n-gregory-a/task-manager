package ru.naumkin.tm;

import ru.naumkin.tm.util.Command;
import ru.naumkin.tm.util.CommandHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App 
{

    public static void main( String[] args ) throws IOException {
        System.out.println( "*** Welcome to task manager ***" );

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            CommandHandler commandHandler = new CommandHandler(reader);

            while (true) {
                Command command = commandHandler.readCommand(reader);
                if (command.getCommand().equals(Command.EXIT.getCommand())) {
                    System.exit(1);
                } else {
                    commandHandler.handleCommand(command);
                }
            }

        }
    }

}
