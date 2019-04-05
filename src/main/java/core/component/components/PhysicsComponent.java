package core.component.components;

import core.component.Component;

public class PhysicsComponent implements Component {
    
    private float force = 1.5f;
    private boolean falling = true;
    private boolean jumping = false;

    public PhysicsComponent() {}

    /**
     * @return the force
     */
    public float getForce() {
        return force;
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
     * @param force the force to set
     */
    public void setForce(float force) {
        this.force = force;
    }

}
