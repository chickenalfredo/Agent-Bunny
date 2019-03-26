package core.ecs.components;

import java.io.Serializable;

import core.ecs.Component;
import core.ecs.components.StateComponent.State;
import core.math.Collision;
import core.math.CollisionPacket;
import core.sprite.Entity;
import core.sprite.Sprite;
import core.sprite.TileObject;
import core.sprite.World;
import javafx.scene.canvas.GraphicsContext;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public class PhysicsComponent extends Component implements Serializable {

    private static final long serialVersionUID = -5236673452137372541L;
    private Sprite actor;
    private double velocityX = 0.0f;
    private double velocityY = 0.0f;
    private double force = 1.5f;
    private boolean falling = true;
    private boolean jumping = false;

    public PhysicsComponent() {}

    /**
     * @return the velocityX
     */
    public double getVelocityX() {
        return velocityX;
    }

    /**
     * @param velocityX the velocityX to set
     */
    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    /**
     * @return the velocityY
     */
    public double getVelocityY() {
        return velocityY;
    }

    /**
     * @param velocityY the velocityY to set
     */
    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    /**
     * @return the force
     */
    public double getForce() {
        return force;
    }

    /**
     * @param force the force to set
     */
    public void setForce(double force) {
        this.force = force;
    }

    /**
     * @return the falling
     */
    public boolean isFalling() {
        return falling;
    }

    /**
     * @param falling the falling to set
     */
    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    /**
     * @return the jumping
     */
    public boolean isJumping() {
        return jumping;
    }

    /**
     * @param jumping the jumping to set
     */
    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    /**
     * 
     * @param actor
     * @param world
     */
    public void update(Sprite actor, World world) {
        if (this.actor == null) {
            this.actor = actor;
        }
        actor.setX(actor.getX() + velocityX);
        actor.setY(actor.getY() + velocityY);
        applyGravity(actor, world);
        collisionDetection(actor, world);
    }

    /**
     * 
     * @param actor
     * @param world
     */
    private void applyGravity(Sprite actor, World world) {
        if (actor instanceof Entity)
            velocityY += force;
    }

    /**
     * 
     * @param key
     * @param isKeyPressedEvent
     */
    public void moveEntity(String key, boolean isKeyPressedEvent) {
        if (isKeyPressedEvent) {
            switch (key) {
            case "a":
                setVelocityX(0);
                setVelocityX(-10);
                // TODO: running right render
                actor.getComponent("StateComponent", StateComponent.class).setState(State.RUNNING);
                break;
            case "d":
                setVelocityX(0);
                setVelocityX(10);
                // TODO: running left render
                actor.getComponent("StateComponent", StateComponent.class).setState(State.RUNNING);
                break;
            }
        } else {
            setVelocityX(0);
            // TODO: idle render
            actor.getComponent("StateComponent", StateComponent.class).setState(State.IDLE);
        }
    }

    /**
     * 
     * @param actor
     * @param world
     */
    public void collisionDetection(Sprite actor, World world) {
        Collision collision = new Collision();
        for (Sprite collider : world.getEntities()) {
            if (collider instanceof TileObject && collision.intersectAABB(actor, collider)) {
                collisionResolution(actor, collider);
            }
        }
    }

    /**
     * 
     * @param actor
     * @param collider
     */
    private void collisionResolution(Sprite actor, Sprite collider) {
        CollisionPacket packet = new CollisionPacket(actor, collider);
        if (packet.getCollisionSide().equals("top")) {
            actor.setY(collider.getY() - actor.getHeight());
            velocityY = 0;
            jumping = false;
            falling = false;
        } else {
            falling = true;
            // TODO: falling render
            actor.getComponent("StateComponent", StateComponent.class).setState(State.FALLING);
        }
        if (packet.getCollisionSide().equals("bottom")) {
            actor.setY(collider.getY() + collider.getHeight());
            velocityY = 0;
        }
        if (packet.getCollisionSide().equals("right")) {
            actor.setX(collider.getX() + actor.getWidth() + 1);
        }
        if (packet.getCollisionSide().equals("left")) {
            actor.setX(collider.getX() - actor.getWidth() - 1);

        }
    }

    /**
     * 
     */
    public void jump() {
        if (!(jumping || falling)) {
            setVelocityY(-30);
            jumping = true;
            falling = true;
            // TODO: jump render
            actor.getComponent("StateComponent", StateComponent.class).setState(State.JUMPING);
        } else {
            actor.getComponent("StateComponent", StateComponent.class).setState(State.IDLE);

        }
    }

    @Override
    public void render(Sprite actor, GraphicsContext gc, long delta) {

    }

}
