package core.game;

import java.io.Serializable;
import java.util.ArrayList;
import core.entity.Entity;
import core.entity.attributes.TypeAttribute;
import core.game.map.Level;
import javafx.scene.canvas.GraphicsContext;

public class World implements Serializable {

    private static final long serialVersionUID = -593390538413494469L;
    private ArrayList<Entity> m_entities;
    private ArrayList<System> m_systems;
    private Entity hero;
    private GameMap level;

    /**
     * 
     */
    public World() {
        init();
    }

    /**
     * 
     * @param gc
     * @param delta
     */
    public void update(GraphicsContext gc, long delta) {
        m_entities = level.getEntities();
        for (Entity s : m_entities) {
            // s.update(this);
            // s.render(gc, delta);
        }
    }

    /**
     * 
     * @return
     */
    public Entity getHero() {
        return hero;
    }

    /**
     * 
     */
    private void setHero() {
        for (Entity s : m_entities) {
            if (s.getAttribute(TypeAttribute.class) != null && s.getAttribute(TypeAttribute.class).getType().equals(TypeAttribute.Type.HERO)) {
                hero = s;
            }
        }
    }

    public void createEntity(Entity actor) {
        level.addEntity(actor);
    }

    /**
     * 
     * @param actor
     */
    public void destroyEntity(Entity actor) {
        level.removeEntity(actor);
    }

    /**
     * 
     * @return
     */
    public ArrayList<Entity> getEntities() {
        return new ArrayList<Entity>(level.getEntities());
    }

    /**
     * 
     */
    private void init() {
        level = new Level();
        m_entities = level.getEntities();
        setHero();
    }

}
