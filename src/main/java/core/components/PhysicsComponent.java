package core.components;

import java.util.List;

import core.math.Collision;
import core.sprite.Entity;
import core.sprite.Sprite;

/**
 * <source: http://gameprogrammingpatterns.com/contents.html>
 */
public class PhysicsComponent {

    private double velocityX = 0.0f;
    private double velocityY = 0.0f;
    private double force = 0.5f;
    private boolean falling = true;
    private boolean jumping = false;

    public PhysicsComponent() {
    }

    /**
     * @return the velocityX
     */
    public double getVelocityX() {
        return velocityX;
    }

    /**
     * @param velocityX
     *                      the velocityX to set
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
     * @param velocityY
     *                      the velocityY to set
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
     * @param force
     *                  the force to set
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
     * @param falling
     *                    the falling to set
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
     * @param jumping
     *                    the jumping to set
     */
    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public void update(Sprite actor, List<Sprite> world) {
        actor.setX(actor.getX() + velocityX);
        actor.setY(actor.getY() + velocityY);
        applyGravity(actor, world);
        collisionDetection(actor, world);
    }

    private void applyGravity(Sprite actor, List<Sprite> world) {
        if (actor instanceof Entity)
            velocityY += force;
    }

    public void stopEntity(String key) {
        switch (key) {
        case "a":
            setVelocityX(0);
            break;
        case "d":
            setVelocityX(0);
            break;
        }
    }

    public void moveEntity(String key) {
        switch (key) {
        case "a":
            setVelocityX(-7);
            break;
        case "d":
            setVelocityX(7);
            break;
        }
    }

    public void collisionDetection(Sprite actor, List<Sprite> world) {
        Collision collision = new Collision();
        for (Sprite collider : world) {
            if (!actor.equals(collider) && collision.intersectAABB(actor, collider)) {
                collisionResolution(actor, collider);
            }
        }
    }

    private void collisionResolution(Sprite actor, Sprite collider) {
        if (topCollision(actor, collider)) {
            actor.setY(collider.getY() - actor.getHeight());
            velocityY = 0;
            jumping = false;
            falling = false;
        } else {
            falling = true;
        }
        if (bottomCollision(actor, collider)) {
            actor.setY(collider.getY() + actor.getHeight());
            velocityY = 0;
        }
        if (rightCollision(actor, collider)) {
            actor.setX(collider.getX() + actor.getWidth());
        }
        if (leftCollision(actor, collider)) {
            actor.setX(collider.getX() - actor.getWidth());
        }
    }

    private double getTopBoundCollision(Sprite actor, Sprite collider) {
        return actor.getY() + actor.getHeight() - collider.getY();
    }

    private double getBottomBoundCollision(Sprite actor, Sprite collider) {
        return collider.getY() + collider.getHeight() - actor.getY();
    }

    private double getLeftBoundCollision(Sprite actor, Sprite collider) {
        return actor.getX() + actor.getWidth() - collider.getX();
    }

    private double getRightBoundCollision(Sprite actor, Sprite collider) {
        return collider.getX() + collider.getWidth() - actor.getX();
    }

    private boolean topCollision(Sprite actor, Sprite collider) {
        return getTopBoundCollision(actor, collider) < getBottomBoundCollision(actor, collider)
                && getTopBoundCollision(actor, collider) < getLeftBoundCollision(actor, collider)
                && getTopBoundCollision(actor, collider) < getRightBoundCollision(actor, collider);
    }

    private boolean bottomCollision(Sprite actor, Sprite collider) {
        return getBottomBoundCollision(actor, collider) < getTopBoundCollision(actor, collider)
                && getBottomBoundCollision(actor, collider) < getLeftBoundCollision(actor, collider)
                && getBottomBoundCollision(actor, collider) < getRightBoundCollision(actor, collider);
    }

    private boolean leftCollision(Sprite actor, Sprite collider) {
        return getLeftBoundCollision(actor, collider) < getRightBoundCollision(actor, collider)
                && getLeftBoundCollision(actor, collider) < getTopBoundCollision(actor, collider)
                && getLeftBoundCollision(actor, collider) < getBottomBoundCollision(actor, collider);
    }

    private boolean rightCollision(Sprite actor, Sprite collider) {
        return getRightBoundCollision(actor, collider) < getLeftBoundCollision(actor, collider)
                && getRightBoundCollision(actor, collider) < getTopBoundCollision(actor, collider)
                && getRightBoundCollision(actor, collider) < getBottomBoundCollision(actor, collider);
    }

    public void jump() {
        if (!(jumping || falling)) {
            setVelocityY(-15);
            jumping = true;
            falling = true;
        }
    }

    public void attack(List<Sprite> world) {
        System.out.println("Attack...");
    }

}
