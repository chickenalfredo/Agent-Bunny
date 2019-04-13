package core.system.systems;

import core.component.PositionComponent;
import core.component.RenderComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.game.World;
import javafx.scene.canvas.GraphicsContext;

/**
 * This class will handle all rendering of static objects. 
 */
public class RenderSystem extends AnimationSystemComponent {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a RenderSystem that will handle all rendering of static objects on
     * the map. By default this System will be enabled and will also have it's
     * render update set to true
     */
    public RenderSystem() {
        setDefaultState();
    }

    @Override
    public void setDefaultState() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(true);
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(RenderComponent.class) != null) {
                addSystemEntity(e);
            }
        }
    }

    @Override
    public void update(World world) {
    }

    @Override
    public void render(GraphicsContext gc, World world) {
        for (Entity e : getSystemEntities()) {
            gc.drawImage(e.getComponent(RenderComponent.class).getImage(),
                    e.getComponent(PositionComponent.class).getX(), e.getComponent(PositionComponent.class).getY());
        }
    }

    @Override
    public void initializeComponents(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(RenderComponent.class) != null) {
                if (!e.getComponent(RenderComponent.class).isInit()) {
                    e.getComponent(RenderComponent.class).init(e);
                }
            }
        }
    }

}
