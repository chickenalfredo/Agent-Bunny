
package core;

import java.util.Timer;
import java.util.TimerTask;
import core.*;


/**
 * Terminal output for Demo 1
 * @author Cloudy Yunfan
 * @since 2019/02/23 11:36
 */


public class GameTerminal{
    
    private static String display;

    /**
	* Print string to the terminal
    */
    public static void print(){
        System.out.println(display);
    }

    /**
	* check if the string is updated
	* @return boolean
    */
    private static boolean isUpdated(){
        return !(getDisplay().equals(display));
    }

    /**
    * Get the display string
	* @return String
    */
    public static String getDisplay(){
        return GameState.getCurrentGameMap().generateMapTerminal();
    }

    /**
	* This is a terminal timer which will refresh each second
    */
    public static void terminalTimer(){
    	TimerTask task = new TimerTask(){
            public void run() {
            	if(isUpdated()){
            		print();
            	}
            }
		};
        Timer timer = new Timer();
        timer.schedule(task, 0, 1000);
    }
    
}