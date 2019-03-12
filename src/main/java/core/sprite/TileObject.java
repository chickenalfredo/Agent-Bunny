package core.sprite;

import core.sprite.Sprite;

/**
 * @author Daniel Contreras
 */
public abstract class TileObject extends Sprite {

    private boolean isCollidable;

    public TileObject(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public TileObject(double x, double y, double width, double height, String image) {
        super(x, y, width, height, image);
    }

    public TileObject(double x, double y) {
        super(x, y);
    }

    public boolean getIsCollidable() {
        return isCollidable;
    }

    public void setIsCollidable(boolean isCollidable) {
        this.isCollidable = isCollidable;
    }

}
