package core.math;

import core.sprite.Sprite;

public class Hit {

    private Sprite collider;
    private boolean collisionOccured = false;
    private String sideCollidedWith;

    public Hit(boolean collision, String side) {
        collisionOccured = collision;
        sideCollidedWith = side;
    }

    /**
     * @return the collider
     */
    public Sprite getCollider() {
        return collider;
    }

    /**
     * @param collider the collider to set
     */
    public void setCollider(Sprite collider) {
        this.collider = collider;
    }

    /**
     * @return the collisionOccured
     */
    public boolean isCollisionOccured() {
        return collisionOccured;
    }

    /**
     * @return the sideCollidedWith
     */
    public String getSideCollidedWith() {
        return sideCollidedWith;
    }

    /**
     * @param sideCollidedWith the sideCollidedWith to set
     */
    public void setSideCollidedWith(String sideCollidedWith) {
        this.sideCollidedWith = sideCollidedWith;
    }

    /**
     * @param collisionOccured the collisionOccured to set
     */
    public void setCollisionOccured(boolean collisionOccured) {
        this.collisionOccured = collisionOccured;
    }


}