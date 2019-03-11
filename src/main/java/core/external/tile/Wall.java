package core.external.tile;

import core.sprite.Sprite;
import core.sprite.TileObject;
import javafx.scene.canvas.GraphicsContext;

public class Wall extends TileObject {

    public Wall(double x, double y, double width, double height) {
        super(x, y, width, height);
        setIsCollidable(true);
        setTerminalChar('#');
    }

    @Override
    public void collisionResolution(Sprite sprite) {
    }

}
