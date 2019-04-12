package core.game;

import java.io.Serializable;
import java.util.ArrayList;
import core.entity.Entity;

/**
 * Storing all the sprites inside a map
 * 
 * @author Cloudy Yunfan
 * @since 2019/02/23 11:36
 * @param String name of the level
 */

public class GameMap implements Serializable {

    private static final long serialVersionUID = 6155530831197383076L;
    private ArrayList<Entity> m_entities = new ArrayList<Entity>();

    public GameMap() {}

    /**
     * Add a Entity to the map
     * 
     * @param Entity - Entity object to be added
     */
    public void addEntity(Entity Entity) {
        this.m_entities.add(Entity);
    }

    /**
     * Remove a Entity from the map by object
     * 
     * @param Entity - Entity object to be removed
     */
    public void removeEntity(Entity Entity) {
        this.m_entities.remove(Entity);
    }

    /**
     * Get all the Entity in this map
     * 
     * @return List<Entity> - all Entity in the map
     */
    public ArrayList<Entity> getEntities() {
        return new ArrayList<Entity>(this.m_entities);
    }

}
