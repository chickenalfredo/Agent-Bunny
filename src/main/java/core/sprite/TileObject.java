package core.sprite;

import core.sprite.Sprite;

/**
 * @author Daniel Contreras
 */
public abstract class TileObject extends Sprite {

    private boolean isCollidable;

    public abstract void collisionReaction(Sprite spriteCollidedWith);

    public TileObject() {}

    public TileObject(char terminalChar, double x, double y, double width, double height) {
        super(terminalChar, x, y, width, height);
    }

    public boolean getIsCollidable() {
        return isCollidable;
    }

    public void setIsCollidable(boolean isCollidable) {
        this.isCollidable = isCollidable;
    }

}
