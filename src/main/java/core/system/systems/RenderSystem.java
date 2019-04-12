package core.system.systems;

import core.component.PositionComponent;
import core.component.RenderComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;

public class RenderSystem extends SystemComponent implements AnimationSystemComponent {

    private static final long serialVersionUID = 1L;

    public RenderSystem() {
        setDefaultState();
    }

    @Override
    public void update(long delta) {
        System.out.println("Updating Render System...");
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(RenderComponent.class) != null) {
                addSystemEntity(e);
            }
        }
    }

    public void init(GraphicsContext gc) {
    }

    public void initializeComponents(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(RenderComponent.class) != null) {
                if (!e.getComponent(RenderComponent.class).isInit()) {
                    e.getComponent(RenderComponent.class).init(e);
                }
            }
        }
    }

    @Override
    public void render(GraphicsContext gc, long time) {
        for (Entity e : getSystemEntities()) {
            gc.drawImage(e.getComponent(RenderComponent.class).getImage(),
                    e.getComponent(PositionComponent.class).getX(), e.getComponent(PositionComponent.class).getY());
        }
    }

    public void setDefaultState() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(true);
    }

}
