package core.system.systems;

import core.component.components.PhysicsComponent;
import core.component.components.PositionComponent;
import core.component.components.StateComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.system.SystemComponent;
import javafx.scene.layout.StackPane;

public class PhysicsSystem extends SystemComponent {

    public PhysicsSystem() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(false);
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(PhysicsComponent.class) != null && e.getComponent(PositionComponent.class) != null
                    && e.getComponent(StateComponent.class) != null) {
                addSystemEntity(e);
            }
        }
    }

    @Override
    public void update(long delta) {
        System.out.println("Updating Physics System...");
    }

    @Override
    public void preUpdate() {
        System.out.println("Pre-updating Physics System...");
    }

    @Override
    public void postUpdate() {
        System.out.println("Post-updating Physics System...");
    }

    @Override
    public void render(StackPane root, long time) {

    }

}
