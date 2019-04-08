package core.game;

import core.entity.EntityManager;
import core.system.SystemManager;
import core.system.systems.*;
import javafx.scene.layout.StackPane;

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

    public void init(StackPane root) {
        systemManager.init(root);
    }

    public void update(long delta) {
        systemManager.update(delta);
    }

    public void render(StackPane root, long time) {
        systemManager.render(root, time);
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
