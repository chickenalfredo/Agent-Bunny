package core.sprite;

import java.io.Serializable;

import core.sprite.Sprite;

/**
 * @author Daniel Contreras
 */
public class TileObject extends Sprite implements Serializable {

    /**
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public TileObject(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

}
