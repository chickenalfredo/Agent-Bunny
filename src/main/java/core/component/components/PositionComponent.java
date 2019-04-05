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

    public PositionComponent() {}

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
        this.y = y;
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
        this.x = x;
    }

}
