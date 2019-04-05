package core.component.components;

import core.component.Component;

/**
 * This component will allow an Entity to have the data necessary for having
 * dimensions. Every Entity should have this component as it is necessary 
 * data for rendering Entities properly.
 */
public class DimensionComponent implements Component {
    
    private float width = 0;
    private float height = 0;

    /** Default constructor sets width and height to zero */
    public DimensionComponent() {}

    /**
     * Consrtucts this Dimension with provided width and height. The provided
     * width and height must be greater than or equal to zero. If a value
     * less than zero is provided the default value of zero will be used
     * 
     * @param width
     * @param height
     */
    public DimensionComponent(float width, float height) {
        setWidth(width);
        setHeight(height);
    }

    /**
     * @return the height
     */
    public float getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(float height) {
        if (height >= 0) {
            this.height = height;
        } else {
            this.height = 0;
        }
    }

    /**
     * @return the width
     */
    public float getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(float width) {
        if (width >= 0) {
            this.width = width;
        } else {
            this.width = 0;
        }
    }

}
