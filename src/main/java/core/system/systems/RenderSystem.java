package core.system.systems;

import core.component.PositionComponent;
import core.component.RenderComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;

public class RenderSystem extends SystemComponent {

    private GraphicsContext gc;
    private static final long serialVersionUID = 1L;

    public RenderSystem() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(true);
    }

    @Override
    public void update(long delta) {
        System.out.println("Updating Render System...");
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(RenderComponent.class) != null) {
                if (e.getComponent(RenderComponent.class).isInit()) {
                    e.getComponent(RenderComponent.class).init();
                }
                addSystemEntity(e);
            }
        }
    }

    public void init(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void render(GraphicsContext gc, long time) {
        for (Entity e : getSystemEntities()) {
            gc.drawImage(e.getComponent(RenderComponent.class).getImage(),
                    e.getComponent(PositionComponent.class).getX(), e.getComponent(PositionComponent.class).getY());
        }
    }

}
