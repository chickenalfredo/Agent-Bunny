package core.external.tile;

import core.sprite.Tile;
/**
 * This class implements a end point tile that allows to set the end point of each level.
 * @author Harry Lee
 */
public class EndPoint extends Tile{
    
    private boolean end = false;

    /**
     * The tile checks for whether if the level is ended or not.
     * @return the state of the level's progress
     */
    public boolean levelEnd(){
        end = true;
        return end;
    }
}