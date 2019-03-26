package core.sprite;

import java.io.Serializable;

import core.ecs.components.AttackComponent;
import core.ecs.components.PhysicsComponent;
import core.ecs.components.WeaponComponent;

/**
 * The abstract Entity class extends Sprite with characteristics for creating
 * new generic entities that will be further defined by concrete subclasses.
 */
public abstract class Entity extends Sprite implements Serializable {

    private static final long serialVersionUID = 2915461139373660808L;

    public Entity() {
        super(null);
    }

    /**
     * 
     * @param entityX
     * @param entityY
     * @param entityWidth
     * @param entityHeight
     */
    public Entity(double entityX, double entityY, double entityWidth, double entityHeight) {
        super(entityX, entityY, entityWidth, entityHeight);
    }

    /**
     * 
     * @param world
     */
    public void update(World world) {
        super.update(world);
        if (getComponent("WeaponComponent", WeaponComponent.class) != null) {
            getComponent("WeaponComponent", WeaponComponent.class).update(this, world);
        }
    }

    /**
     * 
     * @param key
     * @param isKeyPressedEvent
     */
    public void move(String key, boolean isKeyPressedEvent) {
        getComponent("PhysicsComponent", PhysicsComponent.class).moveEntity(key, isKeyPressedEvent);
    }

    /**
     * 
     * @param world
     */
    public void attackCollider(World world) {
        getComponent("AttackComponent", AttackComponent.class).update(this, world);
    }

}
