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

public class PhysicsSystem extends SystemComponent {

    private static final long serialVersionUID = 1L;

    public PhysicsSystem() {
        setDefaultState();
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
    public void update(long delta, World world) {
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

    public void setDefaultState() {
        setEnabled(true);
        setNeedsUpdate(true);
        setNeedsRender(false);
    }

    @Override
    public void render(GraphicsContext gc, long time, World world) {
    }

    private void applyGravity() {
        for (Entity e : getSystemEntities()) {
            e.getComponent(VelocityComponent.class).setVelocityY(e.getComponent(VelocityComponent.class).getVelocityY()
                    + e.getComponent(PhysicsComponent.class).getForce());
        }
    }

}
