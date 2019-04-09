package core.component.components;

import core.component.Component;

/**
 * This component will allow an Entity to have the data necessary for movement. This 
 * class will define the Entities velocity in relation to their current state.
 */
public class VelocityComponent implements Component {
    
    private float velocityX = 0.0f;
    private float velocityY = 0.0f;

    public VelocityComponent() {}

    /**
     * @return the velocityY
     */
    public float getVelocityY() {
        return velocityY;
    }

    /**
     * @param velocityY the velocityY to set
     */
    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }

    /**
     * @return the velocityX
     */
    public float getVelocityX() {
        return velocityX;
    }

    /**
     * @param velocityX the velocityX to set
     */
    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

}
