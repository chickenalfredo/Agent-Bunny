package core.external.tile;

import core.sprite.Tile;
import core.sprite.Sprite;

/**
 * This class implements a isLevelOver point tile that allows to set the
 * isLevelOver point of each level.
 * 
 * @author Harry Lee
 */
public class EndPoint extends Tile {

    private boolean isLevelOver = false;

    public EndPoint(boolean isCollidable, char terminalChar, float x, float y, float width, float height) {
        super(terminalChar, x, y, width, height);
        setIsCollidable(isCollidable);
    }

    public boolean getIsLevelOver() {
        return isLevelOver;
    }

    public void collisionReaction(Sprite spriteCollidedWith) {
        if (spriteCollidedWith != null && spriteCollidedWith.getClass().getSimpleName().equals("Player")) {
            isLevelOver = true;
        } 
    }

}