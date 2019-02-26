package core;

import core.GameTerminal;
import java.util.List;
import java.util.ArrayList;



/**
 * Terminal launcher for Demo 1
 * @author Cloudy Yunfan
 * @since 2019/02/23 11:36
 */

public class TerminalLaucher{

	public static void main(String[] args){

		boolean resume = true;
		while(resume){
			resume = GameTerminal.print();
		}
		
	}


}