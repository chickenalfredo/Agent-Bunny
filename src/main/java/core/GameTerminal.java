package core;

import core.game.World;

/**
 * Terminal output for Demo 1
 * 
 * @author Cloudy Yunfan
 * @since 2019/02/23 11:36
 */
public class GameTerminal {

    private static World world;

    /**
     * Print string to the terminal
     */
    public static boolean print() {
        init();
        printMessage();

        // TODO: Finish terminal version

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
    }

    /**
     * 
     */
    private static void printMessage() {
        StringBuilder str = new StringBuilder();
        str.append("\n----------------------------\n");
        str.append("w: move up\n");
        str.append("a: move left\n");
        str.append("s: move down\n");
        str.append("d: move right\n\n");
        str.append("e: close the game\n");
        str.append("\n----------------------------");
        str.append("\nEnter an action");
        System.out.println(str.toString());
    }

    /**
     * Get the display string
     * 
     * @return String - get terminal string to be print on the terminal
     */
    public static String getDisplay() {
        return "";
    }

    private static void init() {
        world = new World();
    }

}
