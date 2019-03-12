package core.components;

import core.external.tile.Wall;
import core.screens.ScreenBuilder;
import core.sprite.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GraphicsComponent {

    public GraphicsComponent() {} 

    public void update(Sprite actor, GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        if (actor instanceof Wall) {
            actor.setWidth(ScreenBuilder.getPrimaryScreenBounds().getWidth());
            gc.fillRect(actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight());
        } else {
            gc.drawImage(actor.getImage(), actor.getX(), actor.getY());
        }
    }

}
