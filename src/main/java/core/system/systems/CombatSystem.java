package core.system.systems;

import core.component.components.AttackComponent;
import core.component.components.HealthComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.system.SystemComponent;
import javafx.scene.layout.StackPane;

public class CombatSystem extends SystemComponent {

    public CombatSystem() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(false);
    }

    @Override
    public void update(long delta) {
        System.out.println("Updating Combat System...");
        setNeedsUpdate(false);
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(AttackComponent.class) != null && e.getComponent(HealthComponent.class) != null) {
                addSystemEntity(e);
            }
        }
    }

    @Override
    public void render(StackPane root, long time) {

    }

}
