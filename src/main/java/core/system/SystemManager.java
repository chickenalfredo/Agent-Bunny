package core.system;

import java.io.Serializable;
import java.util.ArrayList;

import core.entity.EntityManager;
import core.system.systems.AnimationSystemComponent;
import core.system.systems.CollisionSystem;
import core.game.World;
import javafx.scene.canvas.GraphicsContext;

/**
 * This class manages all of the World's Systems. Initializations, updates and
 * renders will be handled through this manager.
 */
public class SystemManager implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<SystemComponent> m_systems = new ArrayList<SystemComponent>();

    /**
     * Initializes all Systems that are currently in the World
     * 
     * @param entityManager
     */
    public void init(EntityManager entityManager) {
        for (SystemComponent s : m_systems) {
            if (s.getSystemEntities().isEmpty()) {
                s.init(entityManager);
            } else if (s instanceof AnimationSystemComponent) {
                ((AnimationSystemComponent) s).initializeComponents(entityManager);
                s.setDefaultState();
            } else if (s instanceof CollisionSystem) {
                s.setDefaultState();
                ((CollisionSystem) s).addEntities(entityManager);
            }
        }
    }

    /**
     * Updates all Systems in the World that are enabled and also need an update
     * 
     * @param world
     */
    public void update(World world) {
        for (SystemComponent s : m_systems) {
            if (s.needsUpdate() && s.enabled())
                s.update(world);
        }
    }

    /**
     * Renders all Systems that are enabled and need a render update
     * 
     * @param gc
     * @param world
     */
    public void render(GraphicsContext gc, World world) {
        for (SystemComponent s : m_systems) {
            if (s.needsRender() && s.enabled()) {
                s.render(gc, world);
            }
        }
    }

    /**
     * Add Systems to the World
     * 
     * @param systems
     */
    public void addSystems(SystemComponent... systems) {
        for (SystemComponent s : systems) {
            m_systems.add(s);
        }
    }

    /**
     * Returns the specified System if it exists, otherwise the user will recieve a
     * null pointer
     * 
     * @param <T>
     * @param type
     * @return the System
     */
    public <T extends SystemComponent> T getSystem(Class<T> type) {
        for (SystemComponent c : m_systems) {
            if (type.isInstance(c)) {
                return type.cast(c);
            }
        }
        return null;
    }

}
