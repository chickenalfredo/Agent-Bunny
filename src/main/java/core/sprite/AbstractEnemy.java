package core.sprite;

import java.util.List;

import core.components.GraphicsComponent;
import core.sprite.interfaces.EnemyDefense;
import javafx.scene.canvas.GraphicsContext;

public abstract class AbstractEnemy extends Entity implements EnemyDefense {

    private GraphicsComponent graphics = new GraphicsComponent();

    public AbstractEnemy(double x, double y, double width, double height) {
        super(x, y, width, height);
        setIsEnemy(true);
    }

    public AbstractEnemy(double x, double y) {
        super(x, y);
    }

    public void update(List<Sprite> world, GraphicsContext gc) {
        graphics.update(this, gc);
    }

}
