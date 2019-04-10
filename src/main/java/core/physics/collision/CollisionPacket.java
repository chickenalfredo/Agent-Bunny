package core.physics.collision;

import core.component.DimensionComponent;
import core.component.PositionComponent;
import core.entity.Entity;

/**
 * This class will contain data regarding the collision that occured.
 * The data will include the game objects that collided, whether or not
 * they did collide and the side that collision occured.
 */
public class CollisionPacket {

    private Entity actor, collider;
    private final boolean isColliding;
    private Side side;

    /**
     * Constructs a packet with the specified GameObjects
     * 
     * @param actor
     * @param collider
     */
    public CollisionPacket(Entity actor, Entity collider) {
        this.actor = actor;
        this.collider = collider;
        isColliding = setCollisionSide();
    }

    /**
     * @return  The Entity who is colliding
     */
    public Entity getActor() {
        return actor;
    }

    /**
     * @return  The Entity being collided with
     */
    public Entity getCollider() {
        return collider;
    }

    /**
     * @return the isColliding
     */
    public boolean isColliding() {
        return isColliding;
    }

    /**
     * Sets the side the collision occured on
     */
    private boolean setCollisionSide() {
        if (topCollision()) {
            side = Side.TOP;
            
            return true;
        }
        if (bottomCollision()) {
            side = Side.BOTTOM;
            return true;
        }
        if (leftCollision()) {
            side = Side.LEFT;
            return true;
        }
        if (rightCollision()) {
            side = Side.RIGHT;
            return true;
        }
        side = Side.NONE;
        return false;
    }

    /**
     * @return  The side the collision occured on
     */
    public Side getCollisionSide() {
        return side;
    }

    /**
     * @return  True or false depending on whether or not the collision happened on the top side of the collider
     */
    private boolean topCollision() {
        return getTopBoundCollision() < getBottomBoundCollision() && getTopBoundCollision() < getLeftBoundCollision()
                && getTopBoundCollision() < getRightBoundCollision();
    }

    /**
     * @return  True or false depending on whether or not the collision happened on the bottom side of the collider
     */
    private boolean bottomCollision() {
        return getBottomBoundCollision() < getTopBoundCollision() && getBottomBoundCollision() < getLeftBoundCollision()
                && getBottomBoundCollision() < getRightBoundCollision();
    }

    /**
     * @return  True or false depending on whether or not the collision happened on the left side of the collider
     */
    private boolean leftCollision() {
        return getLeftBoundCollision() < getRightBoundCollision() && getLeftBoundCollision() < getTopBoundCollision()
                && getLeftBoundCollision() < getBottomBoundCollision();
    }

    /**
     * @return  True or false depending on whether or not the collision happened on the right side of the collider
     */
    private boolean rightCollision() {
        return getRightBoundCollision() < getLeftBoundCollision() && getRightBoundCollision() < getTopBoundCollision()
                && getRightBoundCollision() < getBottomBoundCollision();
    }

    /**
     * @return  The top bounding side of the bounding box
     */
    private double getTopBoundCollision() {
        return actor.getComponent(PositionComponent.class).getY() + actor.getComponent(DimensionComponent.class).getHeight() - collider.getComponent(PositionComponent.class).getY();
    }

    /**
     * @return  The bottom bounding side of the bounding box
     */
    private double getBottomBoundCollision() {
        return collider.getComponent(PositionComponent.class).getY() + collider.getComponent(DimensionComponent.class).getHeight() - actor.getComponent(PositionComponent.class).getY();
    }

    /**
     * @return  The left bounding side of the bounding box
     */
    private double getLeftBoundCollision() {
        return actor.getComponent(PositionComponent.class).getX() + actor.getComponent(DimensionComponent.class).getWidth() - collider.getComponent(PositionComponent.class).getX();
    }

    /**
     * @return  The right bounding side of the bounding box
     */
    private double getRightBoundCollision() {
        return collider.getComponent(PositionComponent.class).getX() + collider.getComponent(DimensionComponent.class).getWidth() - actor.getComponent(PositionComponent.class).getX();
    }

}