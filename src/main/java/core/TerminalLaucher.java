package core;

import core.GameTerminal;

/**
 * Terminal launcher for Demo 1
 * 
 * @author Cloudy Yunfan
 * @since 2019/02/23 11:36
 */
public class TerminalLaucher {

    /**
     * Main method for terminal version
     * 
     * @param args
     */
    public static void main(String[] args) {
        boolean resume = true;
        GameTerminal.printTitle();
        while (resume) {
            resume = GameTerminal.print();
        }
    }

}
