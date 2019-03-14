package core.external.tile;

import core.sprite.TileObject;

/**
 * This class implements a isLevelOver point tile that allows to set the
 * isLevelOver point of each level.
 * 
 * @author Harry Lee
 */
public class EndPoint extends TileObject {

    private boolean isLevelOver = false;

    /**
     * 
     */
    public EndPoint(double x, double y, double width, double height) {
        super(x, y, width, height);
        setIsCollidable(true);
        setTerminalChar('e');
    }

    public EndPoint(double x, double y, double width, double height, String image) {
        super(x, y, width, height, image);
        setIsCollidable(true);
    }

    public EndPoint(double x, double y) {
        super(x, y);
    }

    /**
     * 
     */
    public boolean getIsLevelOver() {
        return isLevelOver;
    }

}
