package core.system.systems;

import core.component.components.HeroAnimationComponentV2;
import core.component.components.PositionComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.screens.ScreenBuilder;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;

public class AnimationSystem extends SystemComponent {

    private GraphicsContext gc;
    private long lastTime = 0;
    private int i = 0;

    private static final double screenHeight = ScreenBuilder.getPrimaryScreenBounds().getHeight();
    private static final double screenWidth = ScreenBuilder.getPrimaryScreenBounds().getWidth();
    private static final double xOffset = -(screenWidth / 2);
    private static final double yOffset = -(screenHeight / 2);

    public AnimationSystem() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(true);
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(HeroAnimationComponentV2.class) != null) {
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
            if (i >= e.getComponent(HeroAnimationComponentV2.class).animateRunning().size())
                i = 0;
            gc.drawImage(e.getComponent(HeroAnimationComponentV2.class).animateIdle().get(i),
                    e.getComponent(PositionComponent.class).getX(), e.getComponent(PositionComponent.class).getY());
            i++;
        }
    }

}
