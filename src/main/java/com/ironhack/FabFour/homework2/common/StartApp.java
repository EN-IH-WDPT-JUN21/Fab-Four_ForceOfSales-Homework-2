package com.ironhack.FabFour.homework2.common;

import java.io.IOException;
import java.util.Scanner;

public class StartApp {
    private static boolean isRunning = true;


    private static void getTitle() {
        clearConsole();
        System.out.println("  ______                                           __      _____           _              \n" +
                " |  ____|                                         / _|    / ____|         | |             \n" +
                " | |__      ___    _ __    ___    ___      ___   | |_    | (___     __ _  | |   ___   ___ \n" +
                " |  __|    / _ \\  | '__|  / __|  / _ \\    / _ \\  |  _|    \\___ \\   / _` | | |  / _ \\ / __|\n" +
                " | |      | (_) | | |    | (__  |  __/   | (_) | | |      ____) | | (_| | | | |  __/ \\__ \\\n" +
                " |_|       \\___/  |_|     \\___|  \\___|    \\___/  |_|     |_____/   \\__,_| |_|  \\___| |___/\n" +
                "                                                                                          ");
    }

    private static void getThankYouScreen() {
        System.out.println("Thank you for using our CRM! :)\n\nFab Four Team");
    }

    public static void startApp() {
        getTitle();
        System.out.println("Welcome to the best CRM!");
        System.out.println("If you don't know what are you doing here just type: help");

        Scanner scanner = new Scanner(System.in);
        String command;

        while (isRunning) {
            System.out.print(">>> ");
            command = scanner.nextLine();
            readCommands(command);

        }
    }

    public static void readCommands(String command) {
        getTitle();

        if (command.toUpperCase().equals("QUIT")) {
            getThankYouScreen();
            isRunning = false;
        } else {
            CommandHandler.handleCommand(command);
        }
    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
