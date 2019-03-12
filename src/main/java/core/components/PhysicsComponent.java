package core.components;

import java.util.List;

import core.math.Collision;
import core.sprite.Entity;
import core.sprite.Sprite;

public class PhysicsComponent {

    private double t = 0.0;
    private double dt = 1.0f;
    private double position = 0.0f;
    private double velocityX = 0.0f;
    private double velocityY = 0.0f;
    private double force = 0.05f;
    private double mass = 1.0f;
    private boolean falling = true;
    private boolean jumping = false;

    public PhysicsComponent() {}

    /**
     * @return the t
     */
    public double getT() {
        return t;
    }

    /**
     * @param t the t to set
     */
    public void setT(double t) {
        this.t = t;
    }

    /**
     * @return the dt
     */
    public double getDt() {
        return dt;
    }

    /**
     * @param dt the dt to set
     */
    public void setDt(double dt) {
        this.dt = dt;
    }

    /**
     * @return the position
     */
    public double getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(double position) {
        this.position = position;
    }

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
     * @return the mass
     */
    public double getMass() {
        return mass;
    }

    /**
     * @param mass the mass to set
     */
    public void setMass(double mass) {
        this.mass = mass;
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

    public void update(Sprite actor, List<Sprite> world) {
        actor.setX(actor.getX() + velocityX);
        actor.setY(actor.getY() + velocityY);
        applyGravity(actor, world);
        collisionDetection(actor, world);
    }

    private void applyGravity(Sprite actor, List<Sprite> world) {
        if (actor instanceof Entity) {
            if (isFalling() || isJumping())
                velocityY += force;
        }
    }

    public void stopEntity(String key) {
        switch (key) {
        case "w":
        // setVelocityY(0);
            break;
        case "a":
            setVelocityX(0);
            break;
        case "s":
        // setVelocityY(0);
            break;
        case "d":
            setVelocityX(0);
            break;
        }
    }

    public void moveEntity(String key) {
        switch (key) {
        case "w":
        // setVelocityY(-3);
            break;
        case "a":
            setVelocityX(-4);
            break;
        case "s":
        // setVelocityY(3);
            break;
        case "d":
            setVelocityX(4);
            break;
        }
    }

    public void collisionDetection(Sprite actor, List<Sprite> world) {
        Collision collision = new Collision();
        for (Sprite sprite : world) {
            if (!actor.equals(sprite)) {
                if (collision.intersectAABB(actor, sprite)) {
                    actor.setY(sprite.getY() - actor.getHeight());
                    velocityY = 0;
                    jumping = false;
                    falling = false;
                } else {
                    falling = true;
                }
            }
        }
    }

    public void jump() {
        if (!(jumping || falling))
            setVelocityY(-5);
    }

    public void doubleJump() {}

    public void dash() {}
    
    public void duck() {}

    public void attack(Sprite actor, List<Sprite> world) {}

}
