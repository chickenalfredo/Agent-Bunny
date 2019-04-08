package core.system.systems;

import core.component.components.CollisionComponent;
import core.component.components.DimensionComponent;
import core.component.components.PositionComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.system.SystemComponent;
import javafx.scene.layout.StackPane;

public class CollisionSystem extends SystemComponent {

    public CollisionSystem() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(false);
    }

    @Override
    public void update(long delta) {
        System.out.println("Updating Collision System...");
    }

    @Override
    public void preUpdate() {
        System.out.println("Pre-updating Collision System...");
    }

    @Override
    public void postUpdate() {
        System.out.println("Post-updating Collision System...");
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(CollisionComponent.class) != null && e.getComponent(DimensionComponent.class) != null
                    && e.getComponent(PositionComponent.class) != null) {
                addSystemEntity(e);
            }
        }
    }

    @Override
    public void render(StackPane root, long time) {

    }
    
}
