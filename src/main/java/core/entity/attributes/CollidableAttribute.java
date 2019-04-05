package core.entity.attributes;

public final class CollidableAttribute implements Attribute {

    private final boolean IS_COLLIDABLE;

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