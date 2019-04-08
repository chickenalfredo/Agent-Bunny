package core.system.systems;

import core.component.components.PositionComponent;
import core.component.components.RenderComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.screens.ScreenBuilder;
import core.system.SystemComponent;
import javafx.scene.layout.StackPane;

public class RenderSystem extends SystemComponent {

    private StackPane root;

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
    public void preUpdate() {
        System.out.println("Pre-updating Render System...");
    }

    @Override
    public void postUpdate() {
        System.out.println("Post-updating Render System...");
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(RenderComponent.class) != null) {
                addSystemEntity(e);
            }
        }
        addEntitiesToGroup();
    }

    public void init(StackPane root) {
        this.root = root;
    }

    @Override
    public void render(StackPane root, long time) {
        for (Entity e : getSystemEntities()) {
            e.getComponent(RenderComponent.class).getGroup().setTranslateX(
                xOffset + (e.getComponent(RenderComponent.class).getGroup().getBoundsInLocal().getWidth()/2) +
                e.getComponent(PositionComponent.class).getX());
            e.getComponent(RenderComponent.class).getGroup().setTranslateY(
                yOffset + ((e.getComponent(RenderComponent.class).getGroup().getBoundsInLocal().getHeight()/2)) +
                e.getComponent(PositionComponent.class).getY());
        }
    }

    public void addEntitiesToGroup() {
        for (Entity e : getSystemEntities()) {
            e.getComponent(RenderComponent.class).createGroup();
            root.getChildren().add(e.getComponent(RenderComponent.class).getGroup());
        }
    }

}
