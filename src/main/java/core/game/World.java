package core.game;

import java.io.Serializable;
import java.util.ArrayList;
import core.entity.Entity;
import core.entity.attributes.Type;
import core.entity.attributes.TypeAttribute;
import core.game.map.Level;
import javafx.scene.layout.StackPane;

/**
 * This class is the world that contains all GameObjects in the level. The World
 * can add, remove, retrieve and update itself.
 */
public class World implements Serializable {

    private static final long serialVersionUID = -593390538413494469L;
    private ArrayList<Entity> m_entities;
    private Entity hero;
    private GameMap level;
    private Manager manager;

    /**
     * On construction the world will initialize itself by retrieving the setting up
     * the Level and retrieving the Hero for easy access
     */
    public World() {
        level = new Level();
        m_entities = level.getEntities();
        setHero();
        manager = new Manager();
    }

    public void init(StackPane root) {
        manager.init(root);
        manager.init(this);
	}

    /**
     * 
     * @param gc
     * @param delta
     */
    public void update(long delta) {
        manager.update(delta);
    }

    public void render(StackPane root, long time) {
        manager.render(root, time);
    }
    
    public Manager getManager() {
        return manager;
    }

    /**
     * @return The Hero Entity
     */
    public Entity getHero() {
        return hero;
    }

    /**
     * Sets the Hero Entity
     */
    private void setHero() {
        for (Entity s : m_entities) {
            if (s.getAttribute(TypeAttribute.class) != null && s.getAttribute(TypeAttribute.class).getType().equals(Type.HERO)) {
                hero = s;
            }
        }
    }

    /**
     * Adds the specified Entity to the game World
     * 
     * @param actor
     */
    public void createEntity(Entity actor) {
        level.addEntity(actor);
    }

    /**
     * Destroys the specified Entity from the game World
     * 
     * @param actor
     */
    public void destroyEntity(Entity actor) {
        level.removeEntity(actor);
    }

    /**
     * Retrieves all Entities currently in the World
     * 
     * @return
     */
    public ArrayList<Entity> getEntities() {
        return new ArrayList<Entity>(level.getEntities());
    }

}
