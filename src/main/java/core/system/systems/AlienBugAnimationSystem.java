package core.system.systems;

import java.util.ArrayList;

import core.component.AlienBugAnimationComponent;
import core.component.PositionComponent;
import core.component.StateComponent;
import core.component.state.Direction;
import core.component.state.State;
import core.entity.Entity;
import core.entity.EntityManager;
import core.game.World;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AlienBugAnimationSystem extends SystemComponent implements AnimationSystemComponent {

    private static final long serialVersionUID = 1L;
    private transient ArrayList<Image> animateRunning;
    private transient ArrayList<Image> animateIdle;
    private transient ArrayList<Image> animateAttack;

    private int i = 0;
    private long lastAnimation = 0;

    public AlienBugAnimationSystem() {
        setDefaultState();
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(AlienBugAnimationComponent.class) != null) {
                addSystemEntity(e);
                animateRunning = e.getComponent(AlienBugAnimationComponent.class).animateRunning();
                animateIdle = e.getComponent(AlienBugAnimationComponent.class).animateIdle();
                animateAttack = e.getComponent(AlienBugAnimationComponent.class).animateAttack();
            }
        }
    }

    public void init(GraphicsContext gc) {
    }

    public void initializeComponents(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(AlienBugAnimationComponent.class) != null) {
                if (!e.getComponent(AlienBugAnimationComponent.class).isInit()) {
                    e.getComponent(AlienBugAnimationComponent.class).init(e);
                    animateAttack = new ArrayList<Image>();
                    animateIdle = new ArrayList<Image>();
                    animateRunning = new ArrayList<Image>();
                    animateRunning = e.getComponent(AlienBugAnimationComponent.class).animateRunning();
                    animateIdle = e.getComponent(AlienBugAnimationComponent.class).animateIdle();
                    animateAttack = e.getComponent(AlienBugAnimationComponent.class).animateAttack();
                }
            }
        }
    }

    @Override
    public void update(long delta, World world) {
    }

    public void setDefaultState() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(true);
    }

    @Override
    public void render(GraphicsContext gc, long time, World world) {
        for (Entity e : world.getEntities()) {
            if (e.getComponent(AlienBugAnimationComponent.class) != null) {
                if (e.getComponent(StateComponent.class).getState() == State.IDLE) {
                    switch (e.getComponent(StateComponent.class).getConcurrentState()) {
                    case ATTACKING:
                        if (animationTimerOver(100)) {
                            e.getComponent(AlienBugAnimationComponent.class)
                                    .setCurrentRender(animateAttack.get(iterate(animateAttack)));
                        }

                        break;
                    case JUMPING:
                    case FALLING:
                    case NONE:
                        if (animationTimerOver(100)) {
                            e.getComponent(AlienBugAnimationComponent.class)
                                    .setCurrentRender(animateIdle.get(iterate(animateIdle)));
                        }
                        break;
                    }
                } else {
                    switch (e.getComponent(StateComponent.class).getConcurrentState()) {
                    case ATTACKING:
                        if (animationTimerOver(60)) {
                            e.getComponent(AlienBugAnimationComponent.class)
                                    .setCurrentRender(animateAttack.get(iterate(animateAttack)));
                        }
                        break;
                    case JUMPING:
                    case FALLING:
                    case NONE:
                        if (animationTimerOver(60)) {
                            e.getComponent(AlienBugAnimationComponent.class)
                                    .setCurrentRender(animateRunning.get(iterate(animateRunning)));
                        }
                        break;
                    }
                }
                if (e.getComponent(StateComponent.class).getDirection() == Direction.RIGHT) {
                    gc.drawImage(e.getComponent(AlienBugAnimationComponent.class).getCurrentRender(),
                            e.getComponent(PositionComponent.class).getX(),
                            e.getComponent(PositionComponent.class).getY());
                } else {
                    gc.drawImage(e.getComponent(AlienBugAnimationComponent.class).getCurrentRender(),
                            e.getComponent(PositionComponent.class).getX()
                                    + e.getComponent(AlienBugAnimationComponent.class).getCurrentRender().getWidth(),
                            e.getComponent(PositionComponent.class).getY(),
                            -e.getComponent(AlienBugAnimationComponent.class).getCurrentRender().getWidth(),
                            e.getComponent(AlienBugAnimationComponent.class).getCurrentRender().getHeight());
                }
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
