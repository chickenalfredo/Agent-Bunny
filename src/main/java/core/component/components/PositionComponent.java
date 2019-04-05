package core.component.components;

import core.component.Component;

/**
 * This component will allow an Entity to have the data necessary for having a position in
 * the 2D plane. All Entities that are to be rendered and have a position on the screen are
 * to have this component.
 */
public class PositionComponent implements Component {
    
    private float x;
    private float y;

    /**
     * Constructs this position with the default vector position at (0,0)
     */
    public PositionComponent() {
        setX(0f);
        setY(0f);
    }

    /**
     * Constructs this position with the specified vector position. If
     * the position provided is less than 0, the default value zero will be 
     * used instead.
     * 
     * @param x
     * @param y
     */
    public PositionComponent(float x, float y) {
        setX(x);
        setY(y);
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        if (y < 0) {
            this.y = 0;
        } else {
            this.y = y;
        }
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        if (x < 0) {
            this.x = 0;
        } else {
            this.x = x;
        }
    }

}
