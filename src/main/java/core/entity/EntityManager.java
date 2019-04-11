package core.entity;

import java.io.Serializable;
import java.util.ArrayList;

public class EntityManager implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<Entity> m_entities;

    public void init(ArrayList<Entity> entities) {
        m_entities = entities;
    }

    public void addEntity(Entity entity) {
        m_entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        m_entities.remove(entity);
    }

    public ArrayList<Entity> getEntities() {
        return m_entities;
    }

    public void removeDestroyedEntities() {
        System.out.println("Removing destroyed entities...");
    }

}