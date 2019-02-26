package core;


 

//import java.util.Timer;
//import java.util.TimerTask;
import core.*;
import java.util.Scanner;


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
        Scanner scan = new Scanner();
        String str = '';
        str += "                         ←A D→\n";
        str += "What is your next action? ";
        System.out.println(str);

        controlList();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter an action");
        String in = userInput.nextLine();

        List<Sprite> sprite = map.getSprite();
        Sprite player;
        for(Sprite each : sprite){
            if(each instanceof Player){
                player = each;
            }
        }


        if (in.equalsIgnoreCase("w")) {
            player.moveUp();
        }

        if (in.equalsIgnoreCase("a")) {
            player.setDirection(false);
            player.moveLeft();
        }

        if (in.equalsIgnoreCase("s")) {
            player.moveDown();
        }

        if (in.equalsIgnoreCase("d")) {
            player.setDirection(true);
            player.moveRight();
        }
        
        if (in.equalsIgnoreCase("z")) {
            player.attack(attackPower);
        }

        if (in.equalsIgnoreCase("exit")) {
            // Application.exit();
            return false;
        }

        if (in.equalsIgnoreCase("restart")) {
            // Map(Map startup);
        }

        if (in.equalsIgnoreCase("cp")) {
            // Map(Map lastCP);
        }


        String command = scan.nextChar();
        scan.nextLine();



        System.out.println(display);

        return true;

    }

    public static void printTitle(){
        String str = '';
        str += "********************************\n";
        str += "********************************\n";
        str += "**       AnimationGame        **\n";
        str += "**                            **\n";
        str += "**                            **\n";
        str += "**                            **\n";
        str += "**                            **\n";
        str += "**         (๑•̀ㅂ•́)و✧          **\n";
        str += "**          Welcome           **\n";
        str += "**                            **\n";
        str += "**                            **\n";
        str += "**       (Press Enter)        **\n";
        str += "**                            **\n";
        str += "********************************\n";
        str += "********************************\n";
        System.out.println(str);
        level1 = new Chapter1Level1;

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