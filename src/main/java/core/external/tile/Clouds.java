package core.external.tile;

import core.sprite.TileObject;
import core.sprite.Sprite;

public class Clouds extends TileObject {

    public Clouds(double x, double y, double width, double height) {
        super(x, y, width, height);
        setIsCollidable(false);
        setTerminalChar('l');
    }

    public Clouds(double x, double y) {
        super(x, y);
    }

    @Override
    public void collisionResolution(Sprite sprite) {}

}
