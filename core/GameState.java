package core;

import core.map.GameMap;

public class GameState{
    
    public static GameMap getCurrentGameMap(){
        return new GameMap();
    }
}