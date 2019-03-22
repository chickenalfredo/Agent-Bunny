package core.ecs;

import core.sprite.Sprite;
import core.sprite.World;
import javafx.scene.canvas.GraphicsContext;

public abstract class Component {

    public void update(Sprite actor, World world) {}
    public void render(Sprite actor, GraphicsContext gc) {}

}
