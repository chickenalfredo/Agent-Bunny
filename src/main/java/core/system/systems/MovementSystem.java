package core.system.systems;

import core.component.PhysicsComponent;
import core.component.PositionComponent;
import core.component.StateComponent;
import core.component.VelocityComponent;
import core.component.state.ConcurrentState;
import core.component.state.Direction;
import core.component.state.State;
import core.entity.Entity;
import core.entity.EntityManager;
import core.game.World;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;

/**
 * This System handles all movements an Entity in the System can make. By
 * default, any Entity with a velocity, position and state component will be
 * part of this System.
 */
public class MovementSystem extends SystemComponent {

    private static final long serialVersionUID = 1L;
    private String key = null;
    private boolean isKeyPressedEvent = false;

    /**
     * Constructs a MovementSystem with the default values. By default, this System
     * will not be updated unless an Entity has made a request for an update
     */
    public MovementSystem() {
        setDefaultState();
    }

    @Override
    public void setDefaultState() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(false);
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(VelocityComponent.class) != null && e.getComponent(PositionComponent.class) != null
                    && e.getComponent(StateComponent.class) != null) {
                addSystemEntity(e);
            }
        }
    }

    @Override
    public void update(World world) {
        if (getRequester().getComponent(PhysicsComponent.class).isJumping()) {
            getRequester().getComponent(StateComponent.class).setConcurrentState(ConcurrentState.JUMPING);
        }
        if (getRequester().getComponent(PhysicsComponent.class).isFalling()) {
            getRequester().getComponent(StateComponent.class).setConcurrentState(ConcurrentState.FALLING);
        }
        if (key.equals("a") || key.equals("d")) {
            moveEntity(key, isKeyPressedEvent);
        }
        if (key.equals("jump") && isKeyPressedEvent) {
            jump();
        }
        setNeedsUpdate(false);
    }

    @Override
    public void render(GraphicsContext gc, World world) {
    }

    /**
     * @return the isKeyPressedEvent
     */
    public boolean isKeyPressedEvent() {
        return isKeyPressedEvent;
    }

    /**
     * @param isKeyPressedEvent the isKeyPressedEvent to set
     */
    public void setKeyPressedEvent(boolean isKeyPressedEvent) {
        this.isKeyPressedEvent = isKeyPressedEvent;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Moves the entity based on input
     * 
     * @param key
     * @param isKeyPressedEvent
     */
    private void moveEntity(String key, boolean isKeyPressedEvent) {
        if (isKeyPressedEvent) {
            switch (key) {
            case "a":
                getRequester().getComponent(VelocityComponent.class).setVelocityX(0);
                getRequester().getComponent(VelocityComponent.class).setVelocityX(-15);
                getRequester().getComponent(StateComponent.class).setState(State.RUNNING);
                getRequester().getComponent(StateComponent.class).setDirection(Direction.LEFT);

                break;
            case "d":
                getRequester().getComponent(VelocityComponent.class).setVelocityX(0);
                getRequester().getComponent(VelocityComponent.class).setVelocityX(15);
                getRequester().getComponent(StateComponent.class).setState(State.RUNNING);
                getRequester().getComponent(StateComponent.class).setDirection(Direction.RIGHT);
                break;
            }
        } else {
            getRequester().getComponent(VelocityComponent.class).setVelocityX(0);
            getRequester().getComponent(StateComponent.class).setState(State.IDLE);
        }
    }

    /**
     * Performs a jump for the entity
     */
    private void jump() {
        if (!(getRequester().getComponent(PhysicsComponent.class).isJumping()
                || getRequester().getComponent(PhysicsComponent.class).isFalling())) {
            getRequester().getComponent(VelocityComponent.class).setVelocityY(-30);
            getRequester().getComponent(PhysicsComponent.class).setJumping(true);
            getRequester().getComponent(PhysicsComponent.class).setFalling(true);
            getRequester().getComponent(StateComponent.class).setConcurrentState(ConcurrentState.JUMPING);
        } else {
            getRequester().getComponent(StateComponent.class).setConcurrentState(ConcurrentState.FALLING);
        }
    }

}
