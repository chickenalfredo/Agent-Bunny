package core.ecs.components;

import java.io.Serializable;

import core.ecs.Component;
import core.external.entity.Enemy;
import core.external.entity.Hero;
import core.math.Collision;
import core.sprite.Entity;
import core.sprite.Sprite;
import core.sprite.Weapon;
import core.sprite.World;

public class AttackComponent extends Component implements Serializable {

    private double attackPower;
    private Sprite collider;
    private WeaponComponent weaponComponent;

    public AttackComponent() {}

    public void update(Entity actor, World world) {
        weaponComponent = actor.getComponent("WeaponComponent", WeaponComponent.class);
        attackCollider(actor, world);
        if (actor instanceof Hero) {
            attackPower = weaponComponent.getEquippedWeaponDamage();
        }
    }

    private void attackCollider(Entity actor, World world) {
        Weapon weapon = weaponComponent.getEquippedWeapon();
        if (collisionDetected(actor, weapon, world)) {
            resolveAttackCollision();
        }
    }

    private boolean collisionDetected(Entity actor, Weapon weapon, World world) {
        Collision collision = new Collision();
        for (Sprite collider : world.getEntities()) {
            if (collider instanceof Enemy && !actor.equals(collider)) {
                if (collision.intersectAABB(weapon, collider)) {
                    this.collider = collider;
                    return true;
                }
            }
        }
        return false;
    }

    private void resolveAttackCollision() {
        collider.getComponent("HealthComponent", HealthComponent.class).takeDamage(attackPower);
    }

}
