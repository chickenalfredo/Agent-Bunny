package core.sprite;

/**
 * @author Daniel Contreras
 */
public class TileObject extends Sprite {

    private boolean isCollidable;

    public TileObject() {
    }

    public TileObject(char terminalChar, float x, float y, float width, float height) {
        super(terminalChar, x, y, width, height);
    }

    public boolean getIsCollidable() {
        return isCollidable;
    }

    public void setIsCollidable(boolean isCollidable) {
        this.isCollidable = isCollidable;
    }
}
