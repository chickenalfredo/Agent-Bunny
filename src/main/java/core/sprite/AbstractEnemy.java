package core.sprite;

import java.util.List;

import core.components.GraphicsComponent;
import core.components.PhysicsComponent;
import core.sprite.interfaces.EnemyDefense;
import core.sprite.interfaces.Physics;
import javafx.scene.canvas.GraphicsContext;

public abstract class AbstractEnemy extends Entity implements EnemyDefense {

    private GraphicsComponent graphics = new GraphicsComponent();
    private PhysicsComponent physics = new PhysicsComponent();

    public AbstractEnemy(double x, double y, double width, double height) {
        super(x, y, width, height);
        setIsEnemy(true);
    }

    public AbstractEnemy(double x, double y, double width, double height, String image) {
        super(x, y, width, height, image);
        setIsEnemy(true);
    }

    public AbstractEnemy(double x, double y) {
        super(x, y);
    }

}
