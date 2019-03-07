package core.external.tile;

import core.sprite.TileObject;
import core.sprite.Sprite;

public class Clouds extends TileObject {

    public Clouds(double x, double y, double width, double height, char terminalChar) {
        super(terminalChar, x, y, width, height);
        setIsCollidable(false);
    }

    @Override
    public void collisionReaction(Sprite spriteCollidedWith) {
        
    }

    @Override
    public void draw() {}
    @Override
    public void update() {}

}
