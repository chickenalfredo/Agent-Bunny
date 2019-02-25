package core;

import core.external.entity.*;
import core.external.tile.*;


public class App {
    public static void main(String[] args) {
        //Monster m = new Monster("m1", 200, 1, true, 1, 1, 1, 1, 'e');
        //Player p = new Player(1, 1, 1, 1, 'p', false, "p1", 200, 1);
        //EndPoint e = new EndPoint(true, 'b', 1, 1, 1, 1);
    	GameClass c = GameUtility.importClass("file://C:/Users/25985/OneDrive/Desktop/Animation-Game/src/main/java/core/external/entityMonster.jar", "Monster");
    	System.out.println(c);
    }
}
