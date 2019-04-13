package core;

import javafx.application.Application;
import core.App;
import java.util.Scanner;

/**
 * This class is the primary entry point into the program. The user will have
 * the option to run either the terminal version or the GUI version from here.
 */
public class GameLauncher {
    public static void main(String[] args) {
        System.out.println("Would you like to load the terminal or GUI version (Enter 't' or 'g' respectively)");
        Scanner input = new Scanner(System.in);
        String gameVersion = input.nextLine();
        if (gameVersion.equalsIgnoreCase("t")) {
            TerminalLaucher.main(args);
        } else if (gameVersion.equalsIgnoreCase("g")) {
            Application.launch(App.class);
        } else {
            System.out.println("Please enter a valid input:");
            main(null);
        }
        input.close();
    }
}
