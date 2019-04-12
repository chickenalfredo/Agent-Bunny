package core.system.systems;

import java.util.ArrayList;

import core.component.AlienDragonAnimationComponent;
import core.component.PositionComponent;
import core.component.StateComponent;
import core.component.state.Direction;
import core.component.state.State;
import core.entity.Entity;
import core.entity.EntityManager;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AlienDragonAnimationSystem extends SystemComponent {

    private ArrayList<Image> animateRunning;
    private ArrayList<Image> animateIdle;
    private ArrayList<Image> animateAttack;

    private int i = 0;
    private long lastAnimation = 0;

    public AlienDragonAnimationSystem() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(true);
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(AlienDragonAnimationComponent.class) != null) {
                addSystemEntity(e);
                animateRunning = e.getComponent(AlienDragonAnimationComponent.class).animateRunning();
                animateIdle = e.getComponent(AlienDragonAnimationComponent.class).animateIdle();
                animateAttack = e.getComponent(AlienDragonAnimationComponent.class).animateAttack();
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
                        e.getComponent(AlienDragonAnimationComponent.class)
                                .setCurrentRender(animateAttack.get(iterate(animateAttack)));
                    }

                    break;
                case JUMPING:
                case FALLING:
                case NONE:
                    if (animationTimerOver(500)) {
                        e.getComponent(AlienDragonAnimationComponent.class)
                                .setCurrentRender(animateIdle.get(iterate(animateIdle)));
                    }
                    break;
                }
            } else {
                switch (e.getComponent(StateComponent.class).getConcurrentState()) {
                case ATTACKING:
                    if (animationTimerOver(60)) {
                        e.getComponent(AlienDragonAnimationComponent.class)
                                .setCurrentRender(animateAttack.get(iterate(animateAttack)));
                    }
                    break;
                case JUMPING:
                case FALLING:
                case NONE:
                    if (animationTimerOver(60)) {
                        e.getComponent(AlienDragonAnimationComponent.class)
                                .setCurrentRender(animateRunning.get(iterate(animateRunning)));
                    }
                    break;
                }
            }
            if (e.getComponent(StateComponent.class).getDirection() == Direction.RIGHT) {
                gc.drawImage(e.getComponent(AlienDragonAnimationComponent.class).getCurrentRender(),
                        e.getComponent(PositionComponent.class).getX(), e.getComponent(PositionComponent.class).getY());
            } else {
                gc.drawImage(e.getComponent(AlienDragonAnimationComponent.class).getCurrentRender(),
                        e.getComponent(PositionComponent.class).getX()
                                + e.getComponent(AlienDragonAnimationComponent.class).getCurrentRender().getWidth(),
                        e.getComponent(PositionComponent.class).getY(),
                        -e.getComponent(AlienDragonAnimationComponent.class).getCurrentRender().getWidth(),
                        e.getComponent(AlienDragonAnimationComponent.class).getCurrentRender().getHeight());
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
