package core;

import core.sprite.*;
import core.map.*;
import core.external.entity.*;
import core.external.level.*;
import java.util.Scanner;
import java.util.List;

/**
 * Terminal output for Demo 1
 * 
 * @author Cloudy Yunfan
 * @since 2019/02/23 11:36
 */
public class GameTerminal {

    private static GameMap level1;

    /**
     * Print string to the terminal
     */
    public static boolean print() {
        List<Sprite> sprite = level1.getSprite();
        SimulationManager input;
        Scanner userInput = new Scanner(System.in);
        Player player = new Player(0.0, 0.0, 5.0, 5.0, 'x', "Name", 1, 5.0);

        for (Sprite each : sprite) {
            if (each instanceof Player) {
                player = (Player) each;
            }
        }
        System.out.println(getDisplay());
        printMessage();
        String key = userInput.nextLine();
        input = new SimulationManager(key);
        if (input.isSimulationInput(key)) {
            if (input.simulateCollision(player, sprite)) {
                System.out.println("Collision detected");
            } else {
                System.out.println("No Collision");
                player.move(key);
            }
        } else if (key.equalsIgnoreCase("e")) {
            System.exit(0);
        } else if (key.equalsIgnoreCase("c")) {
            System.out.println("Checkpoint not yet implemented");
        } else if (key.equalsIgnoreCase("r")) {
            System.out.println("Restart not yet implemented");
        } else {
            System.out.println("Invalid Input");
        }
        return true;
    }

    /**
     * 
     */
    public static void printTitle() {
        String str = "";
        str += "********************************\n";
        str += "********************************\n";
        str += "**       AnimationGame        **\n";
        str += "**                            **\n";
        str += "**                            **\n";
        str += "**                            **\n";
        str += "**                            **\n";
        str += "**                            **\n";
        str += "**          Welcome           **\n";
        str += "**                            **\n";
        str += "**                            **\n";
        str += "**       (Press Enter)        **\n";
        str += "**                            **\n";
        str += "********************************\n";
        str += "********************************\n";
        System.out.println(str);
        level1 = new Chapter1Level1();
    }

    /**
     * 
     */
    private static void printMessage() {
        System.out.println("\n----------------------------\n" + "w: move up\n" + "a: move left\n" + "s: move down\n"
                + "d: move right\n\n" + "e: close the game\n" + "r: return gamestate to startup position\n"
                + "c: return to last checkpoint" + "\n----------------------------");

        System.out.println("Enter an action");
    }

    /**
     * Get the display string
     * 
     * @return String - get terminal string to be print on the terminal
     */
    public static String getDisplay() {
        return level1.generateMapTerminal();
    }
}
