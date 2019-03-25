package core.sprite;

import java.io.Serializable;

import core.ecs.components.AttackComponent;
import core.ecs.components.PhysicsComponent;
import core.ecs.components.WeaponComponent;
import javafx.scene.canvas.GraphicsContext;

/**
 * The abstract Entity class extends Sprite with characteristics for creating
 * new generic entities that will be further defined by concrete subclasses.
 */
public abstract class Entity extends Sprite implements Serializable {

    public Entity() {
        super(null);
    }

    public Entity(double entityX, double entityY, double entityWidth, double entityHeight) {
        super(entityX, entityY, entityWidth, entityHeight);
    }

    public void update(World world, GraphicsContext gc) {
        super.update(world, gc);
        getComponent("PhysicsComponent", PhysicsComponent.class).update(this, world);
        if (getComponent("WeaponComponent", WeaponComponent.class) != null) {
            getComponent("WeaponComponent", WeaponComponent.class).update(this, gc);
        }
    }

    public void move(String key, boolean isKeyPressedEvent) {
        getComponent("PhysicsComponent", PhysicsComponent.class).moveEntity(key, isKeyPressedEvent);
    }

    public void attackCollider(World world) {
        getComponent("AttackComponent", AttackComponent.class).update(this, world);
    }

}
