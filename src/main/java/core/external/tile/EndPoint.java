package core.external.tile;

import core.sprite.TileObject;
import core.sprite.Sprite;

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

    public EndPoint(double x, double y) {
        super(x, y);
    }

    /**
     * 
     */
    public boolean getIsLevelOver() {
        return isLevelOver;
    }

    @Override
    public void update(double time) {

    }

    @Override
    public void collisionResolution(Sprite spriteCollidedWith) {
        if (spriteCollidedWith != null && spriteCollidedWith.getClass().getSimpleName().equals("Player")) {
            isLevelOver = true;
        } 
    }

}
