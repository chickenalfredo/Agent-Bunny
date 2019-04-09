package core.system.systems;

import core.component.components.AIComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.system.SystemComponent;
import javafx.scene.layout.StackPane;

public class AISystem extends SystemComponent {

    public AISystem() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(false);
    }

    @Override
    public void update(long delta) {
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
    public void render(StackPane root, long time) {

    }

}
