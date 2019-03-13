package core.external.tile;

import core.sprite.TileObject;

public class Wall extends TileObject {

    public Wall(double x, double y, double width, double height) {
        super(x, y, width, height);
        setIsCollidable(true);
        setTerminalChar('#');
    }

    public Wall(double x, double y, double width, double height, String image) {
        super(x, y, width, height, image);
        setIsCollidable(true);
    }

    public Wall(double x, double y) {
        super(x, y);
    }

}
