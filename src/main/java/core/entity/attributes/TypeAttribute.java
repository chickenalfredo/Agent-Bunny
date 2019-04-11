package core.entity.attributes;

/**
 * TypeAttribute allows the Entity object to have a Type attribute.
 * This class will set the Type on construction and can
 * only be retrieved as this class is final.
 */
public final class TypeAttribute implements Attribute {

    private final Type TYPE;

    /**
     * Constructs the object with the specified Type as defined by
     * the enumeration class Type.
     * 
     * @see Type
     * @param type
     */
    public TypeAttribute(Type type) {
        this.TYPE = type;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return TYPE;
    };

}
