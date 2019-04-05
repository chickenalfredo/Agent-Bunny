package core.physics.collision;

import core.component.components.DimensionComponent;
import core.component.components.PositionComponent;
import core.entity.GameObject;

public class CollisionPacket {

    private GameObject actor, collider;
    private final boolean isColliding;
    private String side = "";

    /**
     * 
     * @param actor
     * @param collider
     */
    public CollisionPacket(GameObject actor, GameObject collider) {
        this.actor = actor;
        this.collider = collider;
        isColliding = setCollisionSide();
    }

    /**
     * 
     * @return
     */
    public GameObject getActor() {
        return actor;
    }

    /**
     * 
     * @return
     */
    public GameObject getCollider() {
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
        return actor.getComponent(PositionComponent.class).getY() + actor.getComponent(DimensionComponent.class).getHeight() - collider.getComponent(PositionComponent.class).getY();
    }

    /**
     * 
     * @return
     */
    private double getBottomBoundCollision() {
        return collider.getComponent(PositionComponent.class).getY() + collider.getComponent(DimensionComponent.class).getHeight() - actor.getComponent(PositionComponent.class).getY();
    }

    /**
     * 
     * @return
     */
    private double getLeftBoundCollision() {
        return actor.getComponent(PositionComponent.class).getX() + actor.getComponent(DimensionComponent.class).getWidth() - collider.getComponent(PositionComponent.class).getX();
    }

    /**
     * 
     * @return
     */
    private double getRightBoundCollision() {
        return collider.getComponent(PositionComponent.class).getX() + collider.getComponent(DimensionComponent.class).getWidth() - actor.getComponent(PositionComponent.class).getX();
    }

}