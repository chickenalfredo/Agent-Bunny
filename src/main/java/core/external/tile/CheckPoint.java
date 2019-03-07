package core.external.tile;

import core.sprite.TileObject;
import core.sprite.Sprite;

public class CheckPoint extends TileObject {

    public CheckPoint(double x, double y, double width, double height) {
        super(x, y, width, height);
        setIsCollidable(true);
        setTerminalChar('c');
    }

    @Override
    public void draw() {}

    @Override
    public void update() {}

    @Override
    public void collisionResolution(Sprite sprite) {}

}
