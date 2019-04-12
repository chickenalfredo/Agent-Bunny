package core.game;

import java.io.Serializable;
import core.entity.EntityManager;
import core.system.SystemManager;
import core.system.systems.*;
import javafx.scene.canvas.GraphicsContext;

public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    private SystemManager systemManager;
    private EntityManager entityManager;

    public Manager() {
        entityManager = new EntityManager();
        systemManager = new SystemManager();
        initSystems();
    }

    public void init(World world) {
        if (entityManager.getEntities() == null) {
            System.out.println("init entities");
            entityManager.init(world.getEntities());
        }
        System.out.println("init system");
        systemManager.init(entityManager);
    }

    public void init(GraphicsContext gc) {
        systemManager.init(gc);
    }

    public void update(long delta, World world) {
        systemManager.update(delta, world);
        entityManager.removeDestroyedEntities(world);
        // System.out.println(world.getEntities().size() + " : " + entityManager.getEntities().size());
    }

    public void render(GraphicsContext gc, long time, World world) {
        systemManager.render(gc, time, world);
	}

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public SystemManager getSystemManager() {
        return systemManager;
    }

    private void initSystems() {
        systemManager.addSystems(
            new AISystem(), 
            new CollisionSystem(), 
            new CombatSystem(), 
            new MovementSystem(), 
            new PhysicsSystem(), 
            new RenderSystem(),
            new AlienBugAnimationSystem(),
            new AlienCrabAnimationSystem(),
            new AlienDragonAnimationSystem(),
            new HeroAnimationSystem()
        );
        
    }
}
