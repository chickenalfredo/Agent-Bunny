package core.entity.attributes;

public final class TypeAttribute implements Attribute {

    public enum Type {
        HERO, ENEMY, STATIC_OBJECT
    }

    private final Type TYPE;

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
