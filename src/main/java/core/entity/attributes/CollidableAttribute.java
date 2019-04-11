package core.entity.attributes;

import java.io.Serializable;

/**
 * CollidableAttribute allows the Entity object to have a collidable attribute.
 * This class will set the collidable on construction and can only be retrieved
 * as this class is final.
 */
public final class CollidableAttribute implements Attribute, Serializable {

    private static final long serialVersionUID = 1L;
    private final boolean IS_COLLIDABLE;

    /**
     * Constructs this attribute with the specified collidable value. That
     * is, true if the Entity is meant to be collidable or false otherwise
     * 
     * @param isCollidable
     */
    public CollidableAttribute(boolean isCollidable) {
        this.IS_COLLIDABLE = isCollidable;
    }

    /**
     * @return the isCollidable
     */
    public boolean isCollidable() {
        return IS_COLLIDABLE;
    }

}