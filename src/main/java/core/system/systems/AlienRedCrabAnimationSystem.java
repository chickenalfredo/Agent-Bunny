package core.system.systems;

import java.util.ArrayList;

import core.component.AlienRedCrabAnimationComponent;
import core.component.PositionComponent;
import core.component.StateComponent;
import core.component.state.Direction;
import core.component.state.State;
import core.entity.Entity;
import core.entity.EntityManager;
import core.game.World;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * This class contains animations for Red Alien Crabs
 */
public class AlienRedCrabAnimationSystem extends AnimationSystemComponent {

    private static final long serialVersionUID = 1L;
    private transient ArrayList<Image> animateRunning;
    private transient ArrayList<Image> animateIdle;
    private transient ArrayList<Image> animateAttack;

    public AlienRedCrabAnimationSystem() {
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
            if (e.getComponent(AlienRedCrabAnimationComponent.class) != null) {
                addSystemEntity(e);
                animateRunning = e.getComponent(AlienRedCrabAnimationComponent.class).animateRunning();
                animateIdle = e.getComponent(AlienRedCrabAnimationComponent.class).animateIdle();
                animateAttack = e.getComponent(AlienRedCrabAnimationComponent.class).animateAttack();
            }
        }
    }

    @Override
    public void update(World world) {
    }

    @Override
    public void render(GraphicsContext gc, World world) {
        for (Entity e : world.getEntities()) {
            if (e.getComponent(AlienRedCrabAnimationComponent.class) != null) {
                if (e.getComponent(StateComponent.class).getState() == State.IDLE) {
                    switch (e.getComponent(StateComponent.class).getConcurrentState()) {
                    case ATTACKING:
                        if (animationTimerOver(100)) {
                            e.getComponent(AlienRedCrabAnimationComponent.class)
                                    .setCurrentRender(animateAttack.get(iterate(animateAttack)));
                        }

                        break;
                    case JUMPING:
                    case FALLING:
                    case NONE:
                        if (animationTimerOver(100)) {
                            e.getComponent(AlienRedCrabAnimationComponent.class)
                                    .setCurrentRender(animateIdle.get(iterate(animateIdle)));
                        }
                        break;
                    }
                } else {
                    switch (e.getComponent(StateComponent.class).getConcurrentState()) {
                    case ATTACKING:
                        if (animationTimerOver(60)) {
                            e.getComponent(AlienRedCrabAnimationComponent.class)
                                    .setCurrentRender(animateAttack.get(iterate(animateAttack)));
                        }
                        break;
                    case JUMPING:
                    case FALLING:
                    case NONE:
                        if (animationTimerOver(60)) {
                            e.getComponent(AlienRedCrabAnimationComponent.class)
                                    .setCurrentRender(animateRunning.get(iterate(animateRunning)));
                        }
                        break;
                    }
                }
                if (e.getComponent(StateComponent.class).getDirection() == Direction.RIGHT) {
                    gc.drawImage(e.getComponent(AlienRedCrabAnimationComponent.class).getCurrentRender(),
                            e.getComponent(PositionComponent.class).getX(),
                            e.getComponent(PositionComponent.class).getY());
                } else {
                    gc.drawImage(e.getComponent(AlienRedCrabAnimationComponent.class).getCurrentRender(),
                            e.getComponent(PositionComponent.class).getX() + e
                                    .getComponent(AlienRedCrabAnimationComponent.class).getCurrentRender().getWidth(),
                            e.getComponent(PositionComponent.class).getY(),
                            -e.getComponent(AlienRedCrabAnimationComponent.class).getCurrentRender().getWidth(),
                            e.getComponent(AlienRedCrabAnimationComponent.class).getCurrentRender().getHeight());
                }
            }
        }
    }

    @Override
    public void initializeComponents(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(AlienRedCrabAnimationComponent.class) != null) {
                if (!e.getComponent(AlienRedCrabAnimationComponent.class).isInit()) {
                    e.getComponent(AlienRedCrabAnimationComponent.class).init(e);
                    animateAttack = new ArrayList<Image>();
                    animateIdle = new ArrayList<Image>();
                    animateRunning = new ArrayList<Image>();
                    animateRunning = e.getComponent(AlienRedCrabAnimationComponent.class).animateRunning();
                    animateIdle = e.getComponent(AlienRedCrabAnimationComponent.class).animateIdle();
                    animateAttack = e.getComponent(AlienRedCrabAnimationComponent.class).animateAttack();
                }
            }
        }
    }

}
