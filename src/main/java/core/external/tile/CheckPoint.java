package core.external.tile;

import core.sprite.TileObject;
import javafx.scene.canvas.GraphicsContext;
import core.sprite.Sprite;

public class CheckPoint extends TileObject {

    public CheckPoint(double x, double y, double width, double height) {
        super(x, y, width, height);
        setIsCollidable(true);
        setTerminalChar('c');
    }

    public CheckPoint(double x, double y, double width, double height, String image) {
        super(x, y, width, height, image);
        setIsCollidable(true);
    }

    public CheckPoint(double x, double y) {
        super(x, y);
    }

    @Override
    public void collisionResolution(Sprite sprite) {
    }

}
