package core.entity;

import java.util.ArrayList;
import core.entity.attributes.Attribute;

/**
 * Entity defines all objects in the game world and is an extension
 * of the GameObject class. This class will define a set of attributes to define
 * and differentiate all Entities from one another. 
 */
public class Entity extends GameObject {

    private ArrayList<Attribute> m_attributes = new ArrayList<Attribute>();

    public Entity() {}

    /**
     * Adds an array of attributes to this Entity. The attributes added
     * must be a derivation of the Attribute class. 
     * 
     * @param attributes
     */
    public void addAttribute(Attribute... attributes) {
        for (Attribute a : attributes) {
            m_attributes.add(a);
        }
    }

    /**
     * Removes the specified attribute from this Entity. 
     * 
     * @param attribute
     */
    public void removeAttribute(Attribute attribute) {
        if (m_attributes.contains(attribute)) 
            m_attributes.remove(attribute);
    }

    /**
     * Retrieves the attribute of this object as specified in the parameter. If
     * this object does not contain the Attribute being searched for the result 
     * will be a nullpointer object returned
     * 
     * @param <T>
     * @param type
     * @return      The Attribute requested via the parameter
     */
    public <T extends Attribute> T getAttribute(Class<T> type) {
        for (Attribute c : m_attributes) {
            if (c.getClass().getSimpleName().toString().equals(type.cast(c).getClass().getSimpleName().toString())) {
                return type.cast(c);
            }
        }
        return null;
    }
    
}
