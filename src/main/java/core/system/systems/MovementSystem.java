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
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;

public class MovementSystem extends SystemComponent {

    private static final long serialVersionUID = 1L;
    private String key = null;
    private boolean isKeyPressedEvent = false;

    public MovementSystem() {
        setDefaultState();
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

    @Override
    public void update(long delta) {
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
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(VelocityComponent.class) != null && e.getComponent(PositionComponent.class) != null
                    && e.getComponent(StateComponent.class) != null) {
                addSystemEntity(e);
            }
        }
    }

    public void setDefaultState() {
        setEnabled(true);
        setNeedsUpdate(false);
        setNeedsRender(false);
    }

    @Override
    public void render(GraphicsContext gc, long time) {

    }

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

    private void jump() {
        if (!(getRequester().getComponent(PhysicsComponent.class).isJumping() || getRequester().getComponent(PhysicsComponent.class).isFalling())) {
            getRequester().getComponent(VelocityComponent.class).setVelocityY(-30);
            getRequester().getComponent(PhysicsComponent.class).setJumping(true);
            getRequester().getComponent(PhysicsComponent.class).setFalling(true);
            getRequester().getComponent(StateComponent.class).setConcurrentState(ConcurrentState.JUMPING);
        } else {
            getRequester().getComponent(StateComponent.class).setConcurrentState(ConcurrentState.FALLING);
        }
    }

}
