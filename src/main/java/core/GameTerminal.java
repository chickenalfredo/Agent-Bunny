package core;


 

//import java.util.Timer;
//import java.util.TimerTask;
import core.*;
import core.sprite.*;
import core.map.*;
import core.external.entity.*;
import core.external.level.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;



/**
 * Terminal output for Demo 1
 * @author Cloudy Yunfan
 * @since 2019/02/23 11:36
 */


public class GameTerminal{
    
    private static String display;
    private static GameMap level1;

    /**
    * Print string to the terminal
    */
    public static boolean print(){
        Scanner scan = new Scanner(System.in);
        String str = "";
        str += "";
        str += "What is your next action? ";
        
        System.out.println("\n----------------------------\n" + "w: move up\n" + "a: move left\n" + "s: move down\n"
                + "d: move right\n\n" + "exit: close the game\n" + "restart: return gamestate to startup position\n"
                + "cp: return to last checkpoint" + "\n----------------------------");
        System.out.println(str);

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter an action");
        String in = userInput.nextLine();

        List<Sprite> sprite = level1.getSprite();
        Player player;
        for(Sprite each : sprite){
            if(each instanceof Player){
                player = (Player)each;
            }
        }

        player.receiveInput();



        System.out.println(display);

        return true;

    }

    public static void printTitle(){
        String str = "";
        str += "********************************\n";
        str += "********************************\n";
        str += "**       AnimationGame        **\n";
        str += "**                            **\n";
        str += "**                            **\n";
        str += "**                            **\n";
        str += "**                            **\n";
        str += "**         (à¹‘â?¢Ì?ã…‚â?¢Ì?)Ùˆâœ?          **\n";
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
    * check if the string is updated
    * @return boolean - is the terminal string updated?
    */
    private static boolean isUpdated(){
        return !(getDisplay().equals(display));
    }

    /**
    * Get the display string
    * @return String - get terminal string to be print on the terminal
    */
    public static String getDisplay(){
        return GameState.getCurrentGameMap().generateMapTerminal();
        //return "";
    }

    /**
    * This is a terminal timer which will refresh each second
    */
    public static void terminalTimer(){
        /**
        TimerTask task = new TimerTask(){
            public void run() {
                if(isUpdated()){
                    print();
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0, 1000);
        **/

    }
    
}