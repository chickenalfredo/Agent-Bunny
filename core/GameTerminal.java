import java.util.Timer;
import java.util.TimerTask;


public class GameTerminal{
	
	private static String display;

	public static void print(){
		System.out.println(display);
	}

	private static boolean isUpdated(){
		return !(getDisplay().equals(display));
	}

	public static String getDisplay(){
		return GameState.getCurrentGameMap().generateMapTerminal();
	}

	private static terminalTimer(){
		Timer timer = new Timer();

		TimerTask task = new TimerTask() {   
			if(){

			}
		};
	}
	
}