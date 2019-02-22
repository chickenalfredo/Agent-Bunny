/**
 * This class implements a end point tile that allows to set the end point of each level.
 * @author Harry Lee
 */
public class EndPoint extends Tile{
    /**
     * The tile checks for whether if the level is ended or not.
     * @return the state of the level's progress
     */
    public boolean levelEnd(){
        if(collide(Player)){
            return true;
        }
        return false;
    }
}