package core.math;

import core.sprite.Sprite;

public class CollisionPacket {

    private Sprite actor, collider;
    private String side = "";

    public CollisionPacket(Sprite actor, Sprite collider) {
        this.actor = actor;
        this.collider = collider;
        setCollisionSide();
    }

    /**
     * 
     */
    private void setCollisionSide() {
        if (topCollision()) side = "top";
        if (bottomCollision()) side = "bottom";
        if (leftCollision()) side = "left";
        if (rightCollision()) side = "right";
    }

    /**
     * 
     */
    public String getCollisionSide() {
        return side;
    }

    /**
     * 
     */
    private boolean topCollision() {
        return getTopBoundCollision() < getBottomBoundCollision()
                && getTopBoundCollision() < getLeftBoundCollision()
                && getTopBoundCollision() < getRightBoundCollision();
    }

    /**
     * 
     */
    private boolean bottomCollision() {
        return getBottomBoundCollision() < getTopBoundCollision()
                && getBottomBoundCollision() < getLeftBoundCollision()
                && getBottomBoundCollision() < getRightBoundCollision();
    }

    /**
     * 
     */
    private boolean leftCollision() {
        return getLeftBoundCollision() < getRightBoundCollision()
                && getLeftBoundCollision() < getTopBoundCollision()
                && getLeftBoundCollision() < getBottomBoundCollision();
    }

    /**
     * 
     */
    private boolean rightCollision() {
        return getRightBoundCollision() < getLeftBoundCollision()
                && getRightBoundCollision() < getTopBoundCollision()
                && getRightBoundCollision() < getBottomBoundCollision();
    }

    /**
     * 
     */
    private double getTopBoundCollision() {
        return actor.getY() + actor.getHeight() - collider.getY();
    }

    /**
     * 
     */
    private double getBottomBoundCollision() {
        return collider.getY() + collider.getHeight() - actor.getY();
    }

    /**
     * 
     */
    private double getLeftBoundCollision() {
        return actor.getX() + actor.getWidth() - collider.getX();
    }

    /**
     * 
     */
    private double getRightBoundCollision() {
        return collider.getX() + collider.getWidth() - actor.getX();
    }

}