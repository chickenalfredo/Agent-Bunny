package core.system.systems;

import java.util.ArrayList;

import core.component.AlienCrabAnimationComponent;
import core.component.DimensionComponent;
import core.component.PositionComponent;
import core.component.StateComponent;
import core.component.state.Direction;
import core.component.state.State;
import core.entity.Entity;
import core.entity.EntityManager;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AlienCrabAnimationSystem extends SystemComponent {

    private ArrayList<Image> animateRunning;
    private ArrayList<Image> animateIdle;
    private ArrayList<Image> animateAttack;

    private int i = 0;
    private long lastAnimation = 0;

    public AlienCrabAnimationSystem() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(true);
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(AlienCrabAnimationComponent.class) != null) {
                addSystemEntity(e);
                animateRunning = e.getComponent(AlienCrabAnimationComponent.class).animateRunning();
                animateIdle = e.getComponent(AlienCrabAnimationComponent.class).animateIdle();
                animateAttack = e.getComponent(AlienCrabAnimationComponent.class).animateAttack();
            }
        }
    }

    public void init(GraphicsContext gc) {
    }

    @Override
    public void update(long delta) {
    }

    @Override
    public void render(GraphicsContext gc, long time) {
        for (Entity e : getSystemEntities()) {
            if (e.getComponent(StateComponent.class).getState() == State.IDLE) {
                switch (e.getComponent(StateComponent.class).getConcurrentState()) {
                case ATTACKING:
                    if (animationTimerOver(100)) {
                        e.getComponent(AlienCrabAnimationComponent.class)
                                .setCurrentRender(animateAttack.get(iterate(animateAttack)));
                    }

                    break;
                case JUMPING:
                case FALLING:
                case NONE:
                    if (animationTimerOver(100)) {
                        e.getComponent(AlienCrabAnimationComponent.class)
                                .setCurrentRender(animateIdle.get(iterate(animateIdle)));
                    }
                    break;
                }
            } else {
                switch (e.getComponent(StateComponent.class).getConcurrentState()) {
                case ATTACKING:
                    if (animationTimerOver(60)) {
                        e.getComponent(AlienCrabAnimationComponent.class)
                                .setCurrentRender(animateAttack.get(iterate(animateAttack)));
                    }
                    break;
                case JUMPING:
                case FALLING:
                case NONE:
                    if (animationTimerOver(60)) {
                        e.getComponent(AlienCrabAnimationComponent.class)
                                .setCurrentRender(animateRunning.get(iterate(animateRunning)));
                    }
                    break;
                }
            }
            if (e.getComponent(StateComponent.class).getDirection() == Direction.RIGHT) {
                gc.drawImage(e.getComponent(AlienCrabAnimationComponent.class).getCurrentRender(),
                        e.getComponent(PositionComponent.class).getX(), e.getComponent(PositionComponent.class).getY());
            } else {
                gc.drawImage(e.getComponent(AlienCrabAnimationComponent.class).getCurrentRender(),
                        e.getComponent(PositionComponent.class).getX()
                                + e.getComponent(AlienCrabAnimationComponent.class).getCurrentRender().getWidth(),
                        e.getComponent(PositionComponent.class).getY(),
                        -e.getComponent(AlienCrabAnimationComponent.class).getCurrentRender().getWidth(),
                        e.getComponent(AlienCrabAnimationComponent.class).getCurrentRender().getHeight());
            }
        }
    }

    private int iterate(ArrayList<Image> images) {
        if (i >= images.size() - 1) {
            i = 0;
            return i;
        } else {
            i++;
            return i;
        }
    }

    private boolean animationTimerOver(long duration) {
        long time = System.currentTimeMillis();
        if (time > lastAnimation + duration) {
            lastAnimation = time;
            return true;
        }
        return false;
    }

}
