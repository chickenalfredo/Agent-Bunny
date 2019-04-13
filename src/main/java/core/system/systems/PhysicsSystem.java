package core.system.systems;

import core.component.PhysicsComponent;
import core.component.PositionComponent;
import core.component.StateComponent;
import core.component.VelocityComponent;
import core.component.state.ConcurrentState;
import core.component.state.State;
import core.entity.Entity;
import core.entity.EntityManager;
import core.game.World;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;

/**
 * This System will handle all physics, position, velocity and state components
 * of each entity. By default, all entities within this system will have gravity
 * imposed on them and will constantly be pulled down when required
 */
public class PhysicsSystem extends SystemComponent {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new PhysicsSystem with the default values
     */
    public PhysicsSystem() {
        setDefaultState();
    }

    @Override
    public void setDefaultState() {
        setEnabled(true);
        setNeedsUpdate(true);
        setNeedsRender(false);
    }

    @Override
    public void init(EntityManager entityManager) {
        for (Entity e : entityManager.getEntities()) {
            if (e.getComponent(PhysicsComponent.class) != null && e.getComponent(PositionComponent.class) != null
                    && e.getComponent(VelocityComponent.class) != null) {
                addSystemEntity(e);
                e.getComponent(StateComponent.class).setState(State.IDLE);
                e.getComponent(StateComponent.class).setConcurrentState(ConcurrentState.NONE);
            }
        }
    }

    @Override
    public void update(World world) {
        for (Entity e : world.getEntities()) {
            if (e.getComponent(PhysicsComponent.class) != null && e.getComponent(PositionComponent.class) != null
                    && e.getComponent(VelocityComponent.class) != null) {
                e.getComponent(PositionComponent.class).setX(e.getComponent(PositionComponent.class).getX()
                        + e.getComponent(VelocityComponent.class).getVelocityX());
                e.getComponent(PositionComponent.class).setY(e.getComponent(PositionComponent.class).getY()
                        + e.getComponent(VelocityComponent.class).getVelocityY());
            }

        }
        applyGravity();
    }

    @Override
    public void render(GraphicsContext gc, World world) {
    }

    /**
     * Applies gravity to all entites in this system
     */
    private void applyGravity() {
        for (Entity e : getSystemEntities()) {
            e.getComponent(VelocityComponent.class).setVelocityY(e.getComponent(VelocityComponent.class).getVelocityY()
                    + e.getComponent(PhysicsComponent.class).getForce());
        }
    }

}
