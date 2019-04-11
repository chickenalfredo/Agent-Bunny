package core.system.systems;

import core.component.PhysicsComponent;
import core.component.PositionComponent;
import core.component.VelocityComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.system.SystemComponent;
import javafx.scene.canvas.GraphicsContext;

public class PhysicsSystem extends SystemComponent {

    private static final long serialVersionUID = 1L;

    public PhysicsSystem() {
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
            }
        }
    }

    @Override
    public void update(long delta) {
        for (Entity e : getSystemEntities()) {
            e.getComponent(PositionComponent.class).setX(e.getComponent(PositionComponent.class).getX()
                    + e.getComponent(VelocityComponent.class).getVelocityX());
            e.getComponent(PositionComponent.class).setY(e.getComponent(PositionComponent.class).getY()
                    + e.getComponent(VelocityComponent.class).getVelocityY());
        }
        applyGravity();
    }

    @Override
    public void render(GraphicsContext gc, long time) {

    }

    private void applyGravity() {
        for (Entity e : getSystemEntities()) {
            e.getComponent(VelocityComponent.class).setVelocityY(e.getComponent(VelocityComponent.class).getVelocityY()
                    + e.getComponent(PhysicsComponent.class).getForce());
        }
    }

    // public void jump() {
    //     for (Entity e : getSystemEntities()) {
    //         if (e.getComponent(PhysicsComponent.class).isJumping() || e.getComponent(PhysicsComponent.class).isFalling()) {
    //             e.getComponent(VelocityComponent.class).setVelocityY(-30);
    //             e.getComponent(PhysicsComponent.class).setJumping(true);
    //             e.getComponent(PhysicsComponent.class).setFalling(true);
    //         } else {

    //         }
    //     }
    // }

}
