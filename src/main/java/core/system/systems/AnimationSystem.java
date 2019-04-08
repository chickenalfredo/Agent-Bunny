package core.system.systems;

import core.component.components.AnimationComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.system.SystemComponent;
import javafx.scene.layout.StackPane;

public class AnimationSystem extends SystemComponent {

    public AnimationSystem() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(true);
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(AnimationComponent.class) != null) {
                addSystemEntity(e);
            }
        }
    }

    @Override
    public void preUpdate() {

    }

    @Override
    public void update(long delta) {

    }

    @Override
    public void postUpdate() {

    }

    @Override
    public void render(StackPane root, long time) {

    }

}