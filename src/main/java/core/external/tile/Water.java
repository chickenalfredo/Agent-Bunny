package core.external.tile;

import core.sprite.Tile;
import core.sprite.Sprite;
import core.sprite.Entity;

/**
 * This class implements a isLevelOver point tile that allows to set the
 * isLevelOver point of each level.
 * 
 * @author Harry Lee
 */
public class Water extends Tile {

    public Water(boolean isCollidable, char terminalChar, float x, float y, float width, float height) {
        super(terminalChar, x, y, width, height);
        setIsCollidable(isCollidable);
    }
    /**
     * This method will cause player to die once the player touches water tile.
     */
    public void collisionReaction(Entity entityCollidedWith) {
        if (entityCollidedWith != null && entityCollidedWith.getClass().getSimpleName().equals("Player")) {
            entityCollidedWith.setHealth(0);
        } 
    }

}