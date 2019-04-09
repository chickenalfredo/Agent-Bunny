package core.system.systems;

import core.component.components.HeroAnimationComponent;
import core.component.components.PositionComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.screens.ScreenBuilder;
import core.system.SystemComponent;
import javafx.scene.layout.StackPane;

public class AnimationSystem extends SystemComponent {

    private StackPane root;
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
            if (e.getComponent(HeroAnimationComponent.class) != null) {
                addSystemEntity(e);
                root.getChildren().add(e.getComponent(HeroAnimationComponent.class).getGroup());
            }
        }
    }

    public void init(StackPane root) {
        this.root = root;
	}

    @Override
    public void update(long delta) {

    }

    @Override
    public void render(StackPane root, long time) {
        long curTime = System.currentTimeMillis();
        if (curTime > lastTime + 100) {
            for (Entity e : getSystemEntities()) {
                if (i >= e.getComponent(HeroAnimationComponent.class).animateRunning().size()) {
                    i = 0;
                }
                e.getComponent(HeroAnimationComponent.class).getGroup().setTranslateX(
                    xOffset + (e.getComponent(HeroAnimationComponent.class).getGroup().getBoundsInLocal().getWidth()/2) +
                    e.getComponent(PositionComponent.class).getX());
                e.getComponent(HeroAnimationComponent.class).getGroup().setTranslateY(
                    yOffset + ((e.getComponent(HeroAnimationComponent.class).getGroup().getBoundsInLocal().getHeight()/2)) +
                    e.getComponent(PositionComponent.class).getY());    
                e.getComponent(HeroAnimationComponent.class).getGroup().getChildren().setAll(e.getComponent(HeroAnimationComponent.class).animateIdle().get(i));
                lastTime = curTime;
                i++;
            }
        }
    }

}
