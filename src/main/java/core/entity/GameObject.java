package core.entity;

import java.util.ArrayList;
import core.component.Component;
import com.google.gson.GsonBuilder;

public abstract class GameObject {

    private ArrayList<Component> m_components = new ArrayList<Component>();

    public GameObject() {}

    public void addComponents(Component... components) {
        for (Component c : components) {
            m_components.add(c);
        }
    }

    public void removeComponent(Component component) {
        if (m_components.contains(component)) {
            m_components.remove(component);
        }
    }

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
