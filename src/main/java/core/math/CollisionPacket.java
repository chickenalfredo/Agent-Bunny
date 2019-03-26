package core.math;

import core.sprite.Sprite;

public class CollisionPacket {

    private Sprite actor, collider;
    private boolean isColliding = false;
    private String side = "";

    /**
     * 
     * @param actor
     * @param collider
     */
    public CollisionPacket(Sprite actor, Sprite collider) {
        this.actor = actor;
        this.collider = collider;
        setCollisionSide();
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
     * @param isColliding the isColliding to set
     */
    public void setColliding(boolean isColliding) {
        this.isColliding = isColliding;
    }

    /**
     * 
     */
    private void setCollisionSide() {
        if (topCollision()) {
            side = "top";
            setColliding(true);
        }
        if (bottomCollision()) {
            side = "bottom";
            setColliding(true);
        }
        if (leftCollision()) {
            side = "left";
            setColliding(true);
        }
        if (rightCollision()) {
            side = "right";
            setColliding(true);
        }
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