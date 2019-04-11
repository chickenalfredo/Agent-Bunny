package core.system.systems;

import core.component.HeroAnimationComponent;
import core.component.PositionComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;

public class AnimationSystem extends SystemComponent {

    private static final long serialVersionUID = 1L;
    private transient GraphicsContext gc;
    private int i = 0;

    public AnimationSystem() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(true);
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(HeroAnimationComponent.class) != null) {
                addSystemEntity(e);
            }
        }
    }

    public void init(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void update(long delta) {}

    @Override
    public void render(GraphicsContext gc, long time) {
        for (Entity e : getSystemEntities()) {
            if (i >= e.getComponent(HeroAnimationComponent.class).animateRunning().size())
                i = 0;
            gc.drawImage(e.getComponent(HeroAnimationComponent.class).animateIdle().get(i),
                    e.getComponent(PositionComponent.class).getX(), e.getComponent(PositionComponent.class).getY());
            i++;
        }
    }

}
