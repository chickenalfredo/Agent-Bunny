package core.component.components;

import core.component.Component;

/**
 * This component will allow an Entity to have the data necessary for having
 * dimensions. Every Entity should have this component as it is necessary 
 * data for rendering Entities properly.
 */
public class DimensionComponent implements Component {
    
    private float width;
    private float height;

    public DimensionComponent() {}

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
        this.height = height;
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
        this.width = width;
    }

}
