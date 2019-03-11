package core.external.tile;

import core.sprite.*;

/**
 * This class implements a isLevelOver point tile that allows to set the
 * isLevelOver point of each level.
 * 
 * @author Harry Lee
 */
public class Water extends TileObject {

    public Water(double x, double y, double width, double height) {
        super(x, y, width, height);
        setIsCollidable(true);
        setTerminalChar('*');
    }

    public Water(double x, double y) {
        super(x, y);
    }

    /**
     * This method will cause player to die once the player touches water tile.
     */
    public void collisionReaction(Entity entityCollidedWith) {
        if (entityCollidedWith != null && entityCollidedWith.getClass().getSimpleName().equals("Player")) {
            entityCollidedWith.setHealth(0);
        }
    }

    @Override
    public void collisionResolution(Sprite sprite) {
    }

}