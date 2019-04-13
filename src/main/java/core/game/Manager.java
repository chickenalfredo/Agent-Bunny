package core.game;

import java.io.Serializable;
import core.entity.EntityManager;
import core.system.SystemManager;
import core.system.systems.*;
import javafx.scene.canvas.GraphicsContext;

/**
 * This class manages all Entities and Systems in the World. All systems and
 * entities will be initialized, updated and rendered through this manager.
 */
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    private SystemManager systemManager;
    private EntityManager entityManager;

    /**
     * Constructs a Manager and initializes an EntityManager and a SystemManager
     */
    public Manager() {
        entityManager = new EntityManager();
        systemManager = new SystemManager();
        initSystems();
    }

    /**
     * Initializes all of the entities in the EntityManager and passes a reference
     * to the SystemManager
     * 
     * @param world
     */
    public void init(World world) {
        if (entityManager.getEntities() == null) {
            System.out.println("init entities");
            entityManager.init(world.getEntities());
        }
        System.out.println("init system");
        systemManager.init(entityManager);
    }

    /**
     * Updates all systems of this World that need an update and subsequently will
     * remove all destroyed entities from the World
     * 
     * @param delta
     * @param world
     */
    public void update(World world) {
        systemManager.update(world);
        entityManager.removeDestroyedEntities(world);
    }

    /**
     * Renders all systems that require a render update. By default, all entities
     * that have a render component or animation component will be rendered every
     * frame
     * 
     * @param gc
     * @param time
     * @param world
     */
    public void render(GraphicsContext gc, World world) {
        systemManager.render(gc, world);
    }

    /**
     * @return the World's EntityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * @return the World's SystemManager
     */
    public SystemManager getSystemManager() {
        return systemManager;
    }

    /**
     * Initializes all Systems in the World that this specific World could possibly
     * need
     */
    private void initSystems() {
        systemManager.addSystems(new AISystem(), new CollisionSystem(), new CombatSystem(), new MovementSystem(),
                new PhysicsSystem(), new RenderSystem(), new AlienBugAnimationSystem(), new AlienCrabAnimationSystem(),
                new AlienRedCrabAnimationSystem(), new AlienDragonAnimationSystem(), new HeroAnimationSystem());

    }
}
