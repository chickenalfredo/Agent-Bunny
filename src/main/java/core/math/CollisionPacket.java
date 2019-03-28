package core.math;

import core.sprite.Sprite;

public class CollisionPacket {

    private Sprite actor, collider;
    private final boolean isColliding;
    private String side = "";

    /**
     * 
     * @param actor
     * @param collider
     */
    public CollisionPacket(Sprite actor, Sprite collider) {
        this.actor = actor;
        this.collider = collider;
        isColliding = setCollisionSide();
    }

    /**
     * 
     * @return
     */
    public Sprite getActor() {
        return actor;
    }

    /**
     * 
     * @return
     */
    public Sprite getCollider() {
        return collider;
    }

    /**
     * @return the isColliding
     */
    public boolean isColliding() {
        return isColliding;
    }

    /**
     * 
     */
    private boolean setCollisionSide() {
        if (topCollision()) {
            side = "top";
            return true;
        }
        if (bottomCollision()) {
            side = "bottom";
            return true;
        }
        if (leftCollision()) {
            side = "left";
            return true;
        }
        if (rightCollision()) {
            side = "right";
            return true;
        }
        return false;
    }

    /**
     * 
     * @return
     */
    public String getCollisionSide() {
        return side;
    }

    /**
     * 
     * @return
     */
    private boolean topCollision() {
        return getTopBoundCollision() < getBottomBoundCollision() && getTopBoundCollision() < getLeftBoundCollision()
                && getTopBoundCollision() < getRightBoundCollision();
    }

    /**
     * 
     * @return
     */
    private boolean bottomCollision() {
        return getBottomBoundCollision() < getTopBoundCollision() && getBottomBoundCollision() < getLeftBoundCollision()
                && getBottomBoundCollision() < getRightBoundCollision();
    }

    /**
     * 
     * @return
     */
    private boolean leftCollision() {
        return getLeftBoundCollision() < getRightBoundCollision() && getLeftBoundCollision() < getTopBoundCollision()
                && getLeftBoundCollision() < getBottomBoundCollision();
    }

    /**
     * 
     * @return
     */
    private boolean rightCollision() {
        return getRightBoundCollision() < getLeftBoundCollision() && getRightBoundCollision() < getTopBoundCollision()
                && getRightBoundCollision() < getBottomBoundCollision();
    }

    /**
     * 
     * @return
     */
    private double getTopBoundCollision() {
        return actor.getY() + actor.getHeight() - collider.getY();
    }

    /**
     * 
     * @return
     */
    private double getBottomBoundCollision() {
        return collider.getY() + collider.getHeight() - actor.getY();
    }

    /**
     * 
     * @return
     */
    private double getLeftBoundCollision() {
        return actor.getX() + actor.getWidth() - collider.getX();
    }

    /**
     * 
     * @return
     */
    private double getRightBoundCollision() {
        return collider.getX() + collider.getWidth() - actor.getX();
    }

}