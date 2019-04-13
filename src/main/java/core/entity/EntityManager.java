package core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import core.component.HealthComponent;
import core.game.World;

/**
 * This class manages the Entities that are in the world. This manager is
 * responsible for adding and removing all entities.
 */
public class EntityManager implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<Entity> m_entities;
    private World world;

    /**
     * Initializes this instance with the ArrayList of entities
     * 
     * @param entities
     */
    public void init(ArrayList<Entity> entities) {
        m_entities = entities;
    }

    /**
     * Add the specified entity to this instance
     * 
     * @param entity
     */
    public void addEntity(Entity entity) {
        world.createEntity(entity);
    }

    /**
     * Remove the specified entity from this instance
     * 
     * @param entity
     */
    public void removeEntity(Entity entity) {
        world.destroyEntity(entity);
    }

    /**
     * Sets this instance's entities via the specified ArrayList
     * 
     * @param entities
     */
    public void setEntities(ArrayList<Entity> entities) {
        for (Entity e : entities) {
            addEntity(e);
        }
    }

    /**
     * @return the entities in the manager
     */
    public ArrayList<Entity> getEntities() {
        return m_entities;
    }

    /**
     * Removes all destroyed entities from the manager, effectively removing them
     * from the game
     * 
     * @param world
     */
    public void removeDestroyedEntities(World world) {
        for (Entity e : world.getEntities()) {
            if (e.getComponent(HealthComponent.class) != null) {
                if (!e.getComponent(HealthComponent.class).isAlive()) {
                    world.destroyEntity(e);
                }
            }
        }
        m_entities = world.getEntities();
    }
}
