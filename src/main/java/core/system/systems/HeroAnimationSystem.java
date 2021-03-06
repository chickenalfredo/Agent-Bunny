package core.system.systems;

import java.util.ArrayList;

import core.component.HeroAnimationComponent;
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
 * Updates all Entities who have the HeroAnimationComponent Component
 */
public class HeroAnimationSystem extends AnimationSystemComponent {

    private static final long serialVersionUID = 1L;
    private transient ArrayList<Image> animateRunning;
    private transient ArrayList<Image> animateJump;
    private transient ArrayList<Image> animateIdle;
    private transient ArrayList<Image> animateFalling;
    private transient ArrayList<Image> animateRunAndShoot;
    private transient ArrayList<Image> animateIdleAndShoot;

    /**
     * Constructs the HeroAnimationSystem with the default values. By default, this system
     * will Render at every frame.
     */
    public HeroAnimationSystem() {
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
            if (e.getComponent(HeroAnimationComponent.class) != null) {
                addSystemEntity(e);
                animateRunning = e.getComponent(HeroAnimationComponent.class).animateRunning();
                animateJump = e.getComponent(HeroAnimationComponent.class).AnimateJump();
                animateIdle = e.getComponent(HeroAnimationComponent.class).animateIdle();
                animateFalling = e.getComponent(HeroAnimationComponent.class).animateFalling();
                animateRunAndShoot = e.getComponent(HeroAnimationComponent.class).animateRunAndShoot();
                animateIdleAndShoot = e.getComponent(HeroAnimationComponent.class).animateIdleAndShoot();
            }
        }
    }

    @Override
    public void update(World world) {
    }

    @Override
    public void render(GraphicsContext gc, World world) {
        for (Entity e : getSystemEntities()) {
            if (e.getComponent(StateComponent.class).getState() == State.IDLE) {
                switch (e.getComponent(StateComponent.class).getConcurrentState()) {
                case ATTACKING:
                    if (animationTimerOver(100)) {
                        e.getComponent(HeroAnimationComponent.class)
                                .setCurrentRender(animateIdleAndShoot.get(iterate(animateIdleAndShoot)));
                    }

                    break;
                case JUMPING:
                    if (animationTimerOver(100)) {
                        e.getComponent(HeroAnimationComponent.class)
                                .setCurrentRender(animateJump.get(iterate(animateJump)));
                    }
                    break;
                case FALLING:
                    if (animationTimerOver(100)) {
                        e.getComponent(HeroAnimationComponent.class)
                                .setCurrentRender(animateFalling.get(iterate(animateFalling)));
                    }
                    break;
                case NONE:
                    if (animationTimerOver(100)) {
                        e.getComponent(HeroAnimationComponent.class)
                                .setCurrentRender(animateIdle.get(iterate(animateIdle)));
                    }
                    break;
                }
            } else {
                switch (e.getComponent(StateComponent.class).getConcurrentState()) {
                case ATTACKING:
                    if (animationTimerOver(60)) {
                        e.getComponent(HeroAnimationComponent.class)
                                .setCurrentRender(animateRunAndShoot.get(iterate(animateRunAndShoot)));
                    }
                    break;
                case JUMPING:
                    if (animationTimerOver(100)) {
                        e.getComponent(HeroAnimationComponent.class)
                                .setCurrentRender(animateJump.get(iterate(animateJump)));
                    }
                    break;
                case FALLING:
                    if (animationTimerOver(100)) {
                        e.getComponent(HeroAnimationComponent.class)
                                .setCurrentRender(animateFalling.get(iterate(animateFalling)));
                    }
                    break;
                case NONE:
                    if (animationTimerOver(60)) {
                        e.getComponent(HeroAnimationComponent.class)
                                .setCurrentRender(animateRunning.get(iterate(animateRunning)));
                    }
                    break;
                }
            }
            if (e.getComponent(StateComponent.class).getDirection() == Direction.RIGHT) {
                gc.drawImage(e.getComponent(HeroAnimationComponent.class).getCurrentRender(),
                        e.getComponent(PositionComponent.class).getX(), e.getComponent(PositionComponent.class).getY());
            } else {
                gc.drawImage(e.getComponent(HeroAnimationComponent.class).getCurrentRender(),
                        e.getComponent(PositionComponent.class).getX()
                                + e.getComponent(HeroAnimationComponent.class).getCurrentRender().getWidth(),
                        e.getComponent(PositionComponent.class).getY(),
                        -e.getComponent(HeroAnimationComponent.class).getCurrentRender().getWidth(),
                        e.getComponent(HeroAnimationComponent.class).getCurrentRender().getHeight());
            }
        }
    }

    @Override
    public void initializeComponents(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(HeroAnimationComponent.class) != null) {
                if (!e.getComponent(HeroAnimationComponent.class).isInit()) {
                    e.getComponent(HeroAnimationComponent.class).init(e);
                    animateRunning = new ArrayList<Image>();
                    animateJump = new ArrayList<Image>();
                    animateIdle = new ArrayList<Image>();
                    animateFalling = new ArrayList<Image>();
                    animateRunAndShoot = new ArrayList<Image>();
                    animateIdleAndShoot = new ArrayList<Image>();
                    animateRunning = e.getComponent(HeroAnimationComponent.class).animateRunning();
                    animateJump = e.getComponent(HeroAnimationComponent.class).AnimateJump();
                    animateIdle = e.getComponent(HeroAnimationComponent.class).animateIdle();
                    animateFalling = e.getComponent(HeroAnimationComponent.class).animateFalling();
                    animateRunAndShoot = e.getComponent(HeroAnimationComponent.class).animateRunAndShoot();
                    animateIdleAndShoot = e.getComponent(HeroAnimationComponent.class).animateIdleAndShoot();
                }
            }
        }
    }

}
