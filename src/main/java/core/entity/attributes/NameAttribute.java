package core.entity.attributes;

public final class NameAttribute implements Attribute {
    
    private final String NAME;

    public NameAttribute(String name) {
        this.NAME = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return NAME;
    }
}
