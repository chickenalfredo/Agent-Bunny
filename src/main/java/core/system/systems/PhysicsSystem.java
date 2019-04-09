package core.system.systems;

import core.component.components.PhysicsComponent;
import core.component.components.PositionComponent;
import core.component.components.VelocityComponent;
import core.entity.Entity;
import core.entity.EntityManager;
import core.system.SystemComponent;
import javafx.scene.layout.StackPane;

public class PhysicsSystem extends SystemComponent {

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
    public void render(StackPane root, long time) {

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
