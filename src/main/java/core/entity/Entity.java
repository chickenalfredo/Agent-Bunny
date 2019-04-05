package core.entity;

import java.util.ArrayList;
import core.entity.attributes.Attribute;

public class Entity extends GameObject {

    private ArrayList<Attribute> m_attributes = new ArrayList<Attribute>();

    public Entity() {}

    public void addAttribute(Attribute... attributes) {
        for (Attribute a : attributes) {
            m_attributes.add(a);
        }
    }

    public void removeAttribute(Attribute attribute) {
        if (m_attributes.contains(attribute)) 
            m_attributes.remove(attribute);
    }

    public <T extends Attribute> T getAttribute(Class<T> type) {
        for (Attribute c : m_attributes) {
            if (c.getClass().getSimpleName().toString().equals(type.cast(c).getClass().getSimpleName().toString())) {
                return type.cast(c);
            }
        }
        return null;
    }
    
}
