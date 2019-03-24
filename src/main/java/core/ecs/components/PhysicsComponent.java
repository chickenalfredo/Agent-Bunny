package core.ecs.components;

import java.io.Serializable;

import core.ecs.Component;
import core.math.Collision;
import core.math.CollisionPacket;
import core.sprite.Entity;
import core.sprite.Sprite;
import core.sprite.TileObject;
import core.sprite.World;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public class PhysicsComponent extends Component {

    private double velocityX = 0.0f;
    private double velocityY = 0.0f;
    private double force = 0.5f;
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
     */
    public void update(Sprite actor, World world) {
        actor.setX(actor.getX() + velocityX);
        actor.setY(actor.getY() + velocityY);
        applyGravity(actor, world);
        collisionDetection(actor, world);
    }

    /**
     * 
     */
    private void applyGravity(Sprite actor, World world) {
        if (actor instanceof Entity)
            velocityY += force;
    }

    /**
     * 
     */
    public void moveEntity(String key, boolean isKeyPressedEvent) {
        if (isKeyPressedEvent) {
            switch (key) {
            case "a":
                setVelocityX(0);
                setVelocityX(-7);
                break;
            case "d":
                setVelocityX(0);
                setVelocityX(7);
                break;
            }
        } else {
            setVelocityX(0);
        }
    }

    /**
     * 
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
            setVelocityY(-15);
            jumping = true;
            falling = true;
        }
    }

}
