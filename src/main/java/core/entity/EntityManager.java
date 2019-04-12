package core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import core.component.HealthComponent;
import core.game.World;


public class EntityManager implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<Entity> m_entities;
    private World world;

    public void init(ArrayList<Entity> entities) {
        m_entities = entities;
    }

    public void addEntity(Entity entity) {
        world.createEntity(entity);
    }

    public void removeEntity(Entity entity) {
        world.destroyEntity(entity);
    }

    public void setEntities(ArrayList<Entity> entities) {
        for (Entity e : entities) {
            addEntity(e);
        }
    }

    public ArrayList<Entity> getEntities() {
        return m_entities;
    }

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
