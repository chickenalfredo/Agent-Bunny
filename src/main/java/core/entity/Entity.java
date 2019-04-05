package core.entity;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

import core.component.Component;
import core.entity.attributes.Attribute;

/**
 * Entity defines all objects in the game world and is an extension
 * of the GameObject class. This class will define a set of attributes to define
 * and differentiate all Entities from one another. 
 */
public class Entity {

    private ArrayList<Attribute> m_attributes = new ArrayList<Attribute>();
    private ArrayList<Component> m_components = new ArrayList<Component>();

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

    /**
     * Adds an array of components to this game object. Only components that are
     * derived from the Component base class may be added
     * 
     * @param components
     */
    public void addComponents(Component... components) {
        for (Component c : components) {
            m_components.add(c);
        }
    }

    /**
     * Removes a component from this game object as specified via the parameter 
     * of this function
     * 
     * @param component
     */
    public void removeComponent(Component component) {
        if (m_components.contains(component)) {
            m_components.remove(component);
        }
    }

    /**
     * Retrieves the component of this object as specified in the parameter. If
     * this object does not contain the Component being searched for the result 
     * will be a nullpointer object returned
     * 
     * @param <T>
     * @param type
     * @return      The Component requested via the parameter
     */
    public <T extends Component> T getComponent(Class<T> type) {
        for (Component c : m_components) {
            if (type.isInstance(c)) {
                return type.cast(c);
            }
        }
        return null;
    }

    /*
     * For testing only. Returns a string representation of this object
     * 
     * @return the string representation of the object
     */
    public String toString() {
        return this.getClass().getSimpleName() + " Object "
                + new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
    
}
