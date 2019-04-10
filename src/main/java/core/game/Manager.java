package core.game;

import core.entity.EntityManager;
import core.system.SystemManager;
import core.system.systems.*;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.GraphicsContext;

public class Manager {

    private SystemManager systemManager;
    private EntityManager entityManager;

    public Manager() {
        entityManager = new EntityManager();
        systemManager = new SystemManager();
        initSystems();
    }

    public void init(World world) {
        entityManager.init(world.getEntities());
        systemManager.init(entityManager);
    }

    public void init(GraphicsContext gc) {
        systemManager.init(gc);
    }

    public void update(long delta) {
        systemManager.update(delta);
    }

    public void render(GraphicsContext gc, long time) {
        systemManager.render(gc, time);
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
            new AnimationSystem()
        );
    }

}
