package core.entity;

import java.util.ArrayList;
import core.component.Component;
import com.google.gson.GsonBuilder;

/**
 * Base class for all game objects in the World. All game objects
 * will contain a component that can be added, removed or retrieved via
 * this classes member functions.
 */
public abstract class GameObject {

    private ArrayList<Component> m_components = new ArrayList<Component>();

    public GameObject() {}

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
