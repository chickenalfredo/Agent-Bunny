package core.system.systems;

import core.component.AIComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.game.World;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;

public class AISystem extends SystemComponent {

    public AISystem() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(false);
    }

    @Override
    public void update(long delta, World world) {
        System.out.println("Updating AI System...");
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(AIComponent.class) != null) {
                addSystemEntity(e);
            }
        }
    }

    @Override
    public void render(GraphicsContext gc, long time, World world) {}

}
