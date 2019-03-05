package core.external.tile;

import core.sprite.TileObject;
import core.sprite.Sprite;

public class CheckPoint extends TileObject {

    public CheckPoint(double x, double y, double width, double height, char terminalChar) {
        super(terminalChar, x, y, width, height);
        setIsCollidable(true);
    }

    @Override
    public void collisionReaction(Sprite spriteCollidedWith) {

    }

}
