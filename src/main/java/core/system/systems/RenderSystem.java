package core.system.systems;

import core.component.components.HeroAnimationComponentV2;
import core.component.components.PositionComponent;
import core.component.components.RenderComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.screens.ScreenBuilder;
import core.system.SystemComponent;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.GraphicsContext;

public class RenderSystem extends SystemComponent {

    private GraphicsContext gc;

    private static final double screenHeight = ScreenBuilder.getPrimaryScreenBounds().getHeight();
    private static final double screenWidth = ScreenBuilder.getPrimaryScreenBounds().getWidth();
    private static final double xOffset = -(screenWidth / 2);
    private static final double yOffset = -(screenHeight / 2);

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
            gc.drawImage(e.getComponent(RenderComponent.class).getImage(), e.getComponent(PositionComponent.class).getX(), e.getComponent(PositionComponent.class).getY());
        }
    }

}
